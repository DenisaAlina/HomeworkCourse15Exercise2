package com.fasttrackit;


import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class PersonService {
    private List<Person> personList;

    public PersonService(List<Person> personList) {
        this.personList = personList;
    }

    public Person addPerson(Person person) {
        personList.add(person);
        person.setId(personList.size());
        return person;
    }

    public Person removePerson(Integer id) {
        Boolean found = false;
        for (Person person : personList) {
            if (person.getId() == id) {
                found = true;
                personList.remove(person);
                return person;
            }
        }
        if (found == false) {
            throw new RuntimeException();
        }
        return new Person(null, null);
    }

    public List<Person> getAllPersons() {
        return personList;
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age < 0 || age > 120) {
            throw new RuntimeException();
        }
        List<Person> olderPersonList = new LinkedList<>();
        for (Person person : personList) {
            if (person.getAge() > age) {
                olderPersonList.add(person);
            }
        }
        return olderPersonList;
    }

    public List<String> getAllPersonNames() {
        List<String> personsNames = new LinkedList<>();
        for (Person person : personList) {
            personsNames.add(person.getName());
        }
        return personsNames;
    }

    public Person getPerson(String name) {
        Boolean found = false;
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                found = true;
                return person;
            }
        }
        if (found == false) {
            throw new RuntimeException();
        }
        return new Person(null, null);
    }

    public Person getPersonById(Integer id) {
        Boolean found = false;
        for (Person person : personList) {
            if (person.getId() == id) {
                found = true;
                return person;
            }
        }
        if (found == false) {
            throw new RuntimeException();
        }
        return new Person(null, null);
    }
}
