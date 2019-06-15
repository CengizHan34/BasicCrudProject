package com.crud.BasicCrudProject.controller;

import com.crud.BasicCrudProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/person"})
public class PersonController {

    @Autowired
    PersonService personService;

    @Value("${test}")
    private String test;

    @GetMapping("/create")
    public void createPerson(){
            personService.createPerson();
    }

    @GetMapping("/get")
    public String getTest(){
        return test;
    }
}
