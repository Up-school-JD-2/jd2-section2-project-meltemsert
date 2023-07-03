package data;

import category.PersonType;
import supplier.PersonIdSupplier;

import java.util.Objects;
import java.util.UUID;

public class Person {
    private final String personId;
    private String name;
    private String surName;
    private String phoneNumber;
    private String email;

    private PersonType personType;
    private PersonIdSupplier personIdSupplier = new PersonIdSupplier();

    public Person(String name, String surName, String phoneNumber, String email, PersonType personType) {
        this.personType = personType;
        personIdSupplier.registerPersonIdSupplier(this.personType.name(), () ->
                this.personType.name().substring(0, 4) + "-" + UUID.randomUUID());
        this.personId = personIdSupplier.generatePersonId(this.personType.name());
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surName;
    }

    public void setSurname(String surname) {
        this.surName = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public PersonIdSupplier getPersonIdSupplier() {
        return personIdSupplier;
    }

    public void setPersonIdSupplier(PersonIdSupplier personIdSupplier) {
        this.personIdSupplier = personIdSupplier;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", personType=" + personType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(personId, person.personId)
                && Objects.equals(name, person.name)
                && Objects.equals(surName, person.surName)
                && Objects.equals(phoneNumber, person.phoneNumber)
                && Objects.equals(email, person.email)
                && personType == person.personType
                && Objects.equals(personIdSupplier, person.personIdSupplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, surName, phoneNumber, email, personType, personIdSupplier);
    }
}
