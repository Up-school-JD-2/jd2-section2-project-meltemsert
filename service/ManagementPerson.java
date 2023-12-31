package service;

import backup.BackUpPerson;
import category.PersonType;
import data.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManagementPerson implements Management<Person>, Sort<Person> {
    private Map<String, Person> people = new HashMap<>();

    @Override
    public void add(Person person) {
        people.put(person.getPersonId(), person);
        System.out.println("The person has been successfully added to your phone book " + person);
        BackUpPerson.backUpPerson(person.getPersonId(), person);
    }

    @Override
    public Person remove(String personId) {
        return people.remove(personId);
    }

    @Override
    public void edit(String personId, Consumer<Person> updatePerson) {

        updatePerson.accept(people.get(personId));
    }

    public void editPersonName(String personId, String name) {
        edit(personId, person -> person.setName(name));
        System.out.println("Person's name successfully edited");
    }

    public void editPersonSurname(String personId, String surname) {
        edit(personId, person -> person.setSurname(surname));
        System.out.println("Person's surname successfully edited");
    }

    public void editPersonPhoneNumber(String personId, String phoneNumber) {
        edit(personId, person -> person.setPhoneNumber(phoneNumber));
        System.out.println("Person's phone number successfully edited");
    }

    public void editPersonEmail(String personId, String email) {
        edit(personId, person -> person.setEmail(email));
        System.out.println("Person's email successfully edited");
    }

    public Person searchPerson(String personId) {
        Predicate<Person> pre = person -> people.equals(personId);
        try {
            if (pre.test(people.get(personId))) {
                throw new IllegalArgumentException("This person is not registered in your phone book." +
                        "Enter the person information again ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return people.get(personId);
    }

    public void callPerson(String personId) {
        Person person = searchPerson(personId);
        System.out.println(person.getName() + " " + "is calling");
    }

    public Map<String, Person> getPeople() {
        return people;
    }

    @Override
    public void sort(Map<String, Person> map, Comparator<Person> comparator) {
        map.values().stream().sorted(comparator).toList().forEach(System.out::println);
    }

    public Map<PersonType, List<Person>> categoryPerson() {
        Map<PersonType, List<Person>> categoryPerson = people.values().stream()
                .collect(Collectors.groupingBy(Person::getPersonType));
        return categoryPerson;
    }

    public void listPerson() {
        Iterator<Person> it = people.values().iterator();
        while (it.hasNext()) {
            Person person = it.next();
            System.out.println("Persons in your phone book: " + person);
        }
    }
}
