package com.msbautista.mockapi.repository;

import com.msbautista.mockapi.entity.Endpoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndpointRepository extends CrudRepository<Endpoint, String> {

    Optional<Endpoint> findByName(String name);

}
