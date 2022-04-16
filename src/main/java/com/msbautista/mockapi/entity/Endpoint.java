package com.msbautista.mockapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "endpoint")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endpoint {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "body")
    private String body;

}
