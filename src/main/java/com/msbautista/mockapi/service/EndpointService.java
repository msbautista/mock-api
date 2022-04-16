package com.msbautista.mockapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msbautista.mockapi.entity.Endpoint;
import com.msbautista.mockapi.entity.EndpointMethod;
import com.msbautista.mockapi.exception.EndpointException;
import com.msbautista.mockapi.repository.EndpointRepository;
import com.msbautista.mockapi.request.EndpointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EndpointService {

    private EndpointRepository endpointRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public EndpointService(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }

    public Endpoint addEndpoint(EndpointRequest endpointRequest) throws JsonProcessingException, EndpointException.EndpointAlreadyExists {
        Optional<Endpoint> byName = endpointRepository.findByName(endpointRequest.getName());
        if (byName.isPresent()) {
            throw new EndpointException.EndpointAlreadyExists(endpointRequest.getName());
        }
        var body = endpointRequest.getBody();
        var bodyString = objectMapper.writeValueAsString(body);
        var endpoint = Endpoint.builder()
                .name(endpointRequest.getName())
                .body(bodyString)
                .method(endpointRequest.getMethod().name())
                .build();

        return endpointRepository.save(endpoint);
    }

    public Object returnEndpointBody(String endpointName, EndpointMethod method) throws JsonProcessingException, EndpointException.EndpointDoesNotExists {
        var endpoint = endpointRepository.findByName(endpointName);
        if (endpoint.isEmpty() || !endpoint.get().getMethod().equals(method.name())) {
            throw new EndpointException.EndpointDoesNotExists(endpointName);
        }

        return objectMapper.readValue(endpoint.get().getBody(), Object.class);
    }


}
