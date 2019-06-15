package com.crud.BasicCrudProject.service;

import com.crud.BasicCrudProject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void createPerson() {
        personRepository.createPersons();
    }
}
