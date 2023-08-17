package com.example.personcontroller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**@Entity is used to mark the Java class under it as a persistent entity meaning it will be mapped to a database table
An entity represents a table in RDBS, each instance on this entity corresponds to a row in a table, and the columns represent
the attributes or fields.

 **/
@Entity
public class Person {
    //https://stackoverflow.com/questions/47676403/spring-generatedvalue-annotation-usage
    //different ways to generate PKs
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String firstName;
    String lastName;


    protected Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Person(Long id , String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}