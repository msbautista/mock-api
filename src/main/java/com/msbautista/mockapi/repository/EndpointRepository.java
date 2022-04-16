package com.msbautista.mockapi.repository;

import com.msbautista.mockapi.entity.Endpoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointRepository extends CrudRepository<String, Endpoint> {
}
