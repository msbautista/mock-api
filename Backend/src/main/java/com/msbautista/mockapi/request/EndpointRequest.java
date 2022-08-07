package com.msbautista.mockapi.request;

import com.msbautista.mockapi.entity.EndpointMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EndpointRequest {

    private String name;
    private Object body;
    private EndpointMethod method;

}
