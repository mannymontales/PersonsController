package com.example.personcontroller.controller;

import com.example.personcontroller.PersonRepository;
import com.example.personcontroller.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PersonController {
    private final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepository personRepository;
    public Person createPerson(Person p) {
        return p;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        LOG.info("getting user with id: {}", id);

        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findById(id));
    }

    public List<Person> getPersonList() {
        List<Person> listy = new ArrayList<>();
        return listy;
    }

    public Person updatePerson(Person p) {
        return Person;
    }

    void DeletePerson(int id){

    }

}
