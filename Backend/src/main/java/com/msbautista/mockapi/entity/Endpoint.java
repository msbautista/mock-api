package com.msbautista.mockapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "endpoint")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endpoint {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "body", nullable = false)
    private String body;
    @Column(name = "method", nullable = false)
    private String method;


}
