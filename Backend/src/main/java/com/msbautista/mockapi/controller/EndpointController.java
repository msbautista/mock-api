package com.msbautista.mockapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msbautista.mockapi.entity.EndpointMethod;
import com.msbautista.mockapi.exception.EndpointException;
import com.msbautista.mockapi.request.EndpointRequest;
import com.msbautista.mockapi.response.ApiResponse;
import com.msbautista.mockapi.service.EndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EndpointController {

    private final String INTERNAL_SERVER_ERROR_MESSAGE = "An error occurred while processing the request.";

    private EndpointService endpointService;

    @Autowired
    public EndpointController(EndpointService endpointService) {
        this.endpointService = endpointService;
    }

    @PostMapping("/addEndpoint")
    public ResponseEntity<Object> addEndpoint(@RequestBody EndpointRequest endpointRequest) {
        try {
            var endpoint = endpointService.addEndpoint(endpointRequest);
            return new ApiResponse(endpoint).send(HttpStatus.OK);
        } catch (EndpointException.EndpointAlreadyExists e) {
            return new ApiResponse().send(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return new ApiResponse().send(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
        }
    }

    @GetMapping("/**")
    public ResponseEntity<Object> returnEndpointBodyByGET(HttpServletRequest request) {
        try {
            var endpointName = getEndpointName(request);
            var body = endpointService.returnEndpointBody(endpointName, EndpointMethod.GET);
            return ResponseEntity.ok(body);
        } catch (EndpointException.EndpointDoesNotExists e) {
            return new ApiResponse().send(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return new ApiResponse().send(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
        }
    }

    @PostMapping("/**")
    public ResponseEntity<Object> returnEndpointBodyByPOST(HttpServletRequest request) {
        try {
            var endpointName = getEndpointName(request);
            var body = endpointService.returnEndpointBody(endpointName, EndpointMethod.POST);
            return ResponseEntity.ok(body);
        } catch (EndpointException.EndpointDoesNotExists e) {
            return new ApiResponse().send(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            return new ApiResponse().send(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
        }
    }

    private String getEndpointName(HttpServletRequest request) {
        var URI = request.getRequestURI();

        return URI.substring(1, URI.length());
    }


}
