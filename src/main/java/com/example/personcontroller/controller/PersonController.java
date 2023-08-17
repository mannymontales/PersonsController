package com.example.personcontroller.controller;

import com.example.personcontroller.model.Person;
import com.example.personcontroller.service.PersonServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
//    Person createPerson(Person p), Person getPerson(int id),
//    List<Person> getPersonList(), Person updatePerson(Person p), and void DeletePerson(int id)

    PersonServiceImplementation personServiceImplementation;
    Person p;

    @Autowired
    PersonController(PersonServiceImplementation person1) {
        this.personServiceImplementation = person1;
    }

    private final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    // =========================================== Get All Users ==========================================
    //@RequestMapping(method =  RequestMethod.GET)
    @GetMapping()
    public ResponseEntity<List<Person>> getPersonList() {
        LOG.info("Getting all users" );
        return new ResponseEntity<List<Person>>(personServiceImplementation.getPersonList(), HttpStatus.OK);
    }

    // =========================================== Get User By ID =========================================
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        LOG.info("getting user with id: {}", id);

        return new ResponseEntity<Person>(personServiceImplementation.getPerson(id), HttpStatus.CREATED);
    }

    // =========================================== Create New Person =========================================
    //In this snippet, you're using the older style of mapping requests using the @RequestMapping annotation.
    // The method = RequestMethod.POST attribute specifies that this method will handle HTTP POST requests.
    // The @ResponseBody annotation indicates that the method's return value should be directly serialized into the HTTP response body.
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Person> createPerson(@ResponseBody Person p) {
//        LOG.info("creating new user: {}", p);
//
//        return new ResponseEntity<>(personServiceImplementation.createPerson(p), HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personServiceImplementation.createPerson(p), HttpStatus.CREATED);
    }

    // =========================================== Update Existing User ===================================
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Person p) {
        Person updatedPerson = personServiceImplementation.updatePerson(p);
        return new ResponseEntity<Person>(personServiceImplementation.updatePerson(updatedPerson), HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> DeletePerson(@PathVariable Integer id) {

        LOG.info("deleting user with id: {}", id);

        personServiceImplementation.deletePerson(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
