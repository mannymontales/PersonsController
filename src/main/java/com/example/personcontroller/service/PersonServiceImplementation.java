package com.example.personcontroller.service;

import com.example.personcontroller.PersonRepository;
import com.example.personcontroller.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonServiceImplementation implements  PersonService {

    //@autowired? this shi gave squiglies because of some way to auto wire old version of doing it this is now the new way
    private final PersonRepository personRepository;

    //inject as constructor
    @Autowired
    PersonServiceImplementation(PersonRepository person1) {
        this.personRepository = person1;
    }

    private static final List<Person> persons = new ArrayList<>();
    private static Person p;
    @Override
    public Person createPerson(Person p) {
        personRepository.save(p);
        return new Person(p);
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public List<Person> getPersonList() {
        return persons;
    }

    @Override
    public Person updatePerson(Person p) {
        return null;
    }

    @Override
    public void DeletePerson(int id) {

    }

    @Override
    public boolean exists(Person p) {
        return false;
    }
}
