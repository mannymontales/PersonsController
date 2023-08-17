package com.example.personcontroller.service;

import com.example.personcontroller.model.Person;

import java.util.List;

public interface PersonService {

    //Business Logic Layer
    //Services are typically responsible for containing the business logic of your application.
    // They handle data processing, manipulation, calculations, and any other logic required to fulfill the requirements of your application.
    //Services are usually not concerned with handling HTTP requests or presentation layer concerns. They focus on the application's core functionality.
    //The logic of the application this is where all the data gets manipulated the, Controller is focused on network traffic and http requests

    Person createPerson(Person p);
    Person getPerson(int id);
    List<Person> getPersonList();
    Person updatePerson(Person p);
    void deletePerson(int id);

}
