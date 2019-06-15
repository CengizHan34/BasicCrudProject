package com.crud.BasicCrudProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_test")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String lastName;
    private boolean cover;

    public Person(String name, String lastName, boolean cover) {
        this.name = name;
        this.lastName = lastName;
        this.cover = cover;
    }
}
