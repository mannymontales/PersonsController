package com.example.personcontroller.service;

import com.example.personcontroller.PersonRepository;
import com.example.personcontroller.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonServiceImplementation implements  PersonService {

    //@autowired? this shi gave squiglies because of some way to auto wire old version of doing it this is now the new way
    private PersonRepository personRepository;

    //inject as constructor
    @Autowired
    PersonServiceImplementation(PersonRepository person1) {
        this.personRepository = person1;
    }

    @Override
    public Person createPerson(Person p) {
        return personRepository.save(p);
    }

    @Override
    public Person getPerson(int id) {
        if (personRepository.findById((long) id).isPresent()){
            return personRepository.findById((long) id).get();
        }
        return null;
    }

    @Override
    public List<Person> getPersonList() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person updatePerson(Person p) {
        //get the current person object if it exists by id
        Optional<Person> optionalPerson = personRepository.findById(p.getId());

        //if exists execute this conditional
        if (optionalPerson.isPresent()) {
            //get() returns the instance of the Person object
            //optionalPerson.get() is returning the person object to the existing person
            Person existingPerson = optionalPerson.get();
            //changing the fields
            existingPerson.setFirstName(p.getFirstName());
            existingPerson.setLastName(p.getLastName());

            //saving the new object
            return personRepository.save(p);
        } else {
            return null;
        }
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById((long) id);
    }

}
