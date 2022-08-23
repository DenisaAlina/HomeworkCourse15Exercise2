package com.fasttrackit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class PersonServiceTest {

    @Test
    public void addMethod() {
        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());

        //WHEN
        Person result = personService.addPerson(new Person(20, "Alina"));

        //THEN
        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(personService.getPersonList()).isNotEmpty();
        Assertions.assertThat(personService.getPersonList()).contains(result);

    }

    @Test
    public void removeMethod() {

        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        personService.addPerson(new Person(20, "Alina"));
        personService.addPerson(new Person(22, "Adina"));
        personService.addPerson(new Person(27, "Denisa"));

        //WHEN
        Person result = personService.removePerson(2);

        //THEN
        Assertions.assertThat(result.getId()).isEqualTo(2);
        Assertions.assertThat(personService.getPersonList()).doesNotContain(result);


    }
    @Test
    public void removeMethodThrowExceptionTest() {

        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        personService.addPerson(new Person(20, "Alina"));
        personService.addPerson(new Person(22, "Adina"));
        personService.addPerson(new Person(27, "Denisa"));

        //WHEN
        Person result = personService.removePerson(2);

        //THEN
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            personService.removePerson(10);
        });

    }

    @Test
    public void testGetAllPersons() {
        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        Person person1 = new Person(20, "Alina");
        Person person2 = new Person(22, "Adina");
        Person person3 = new Person(27, "Denisa");
        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);

        //WHEN
        List<Person> personList = personService.getAllPersons();

        //THEN
        Assertions.assertThat(personList).isNotEmpty();
        Assertions.assertThat(personList).containsExactly(person1, person2, person3);
        Assertions.assertThat(personList).hasSize(3);
    }


    @Test
    public void testGetPersonsOlderThan() {
        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        Person person1 = new Person(20, "Alina");
        Person person2 = new Person(22, "Adina");
        Person person3 = new Person(27, "Denisa");
        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);

        //WHEN
        List<Person> personList = personService.getPersonsOlderThan(21);

        //THEN
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            personService.getPersonsOlderThan(130);
        });
        Assertions.assertThat(personList).hasSize(2);
        Assertions.assertThat(personList).isNotEmpty();
        Assertions.assertThat(personList).containsExactly(person2, person3);
    }

    @Test
    public void testGetAllPersonNames() {
        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        personService.addPerson(new Person(20, "Alina"));
        personService.addPerson(new Person(22, "Adina"));
        personService.addPerson(new Person(27, "Denisa"));

        //WHEN
        List<String> nameList = personService.getAllPersonNames();

        //THEN
        Assertions.assertThat(nameList).hasSize(3);
        Assertions.assertThat(nameList).isNotEmpty();
        Assertions.assertThat(nameList).containsExactly("Alina", "Adina", "Denisa");

    }

    @Test
    public void testGetPerson() {
        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        Person person1 = new Person(20, "Alina");
        Person person2 = new Person(22, "Adina");
        Person person3 = new Person(27, "Denisa");
        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);


        //WHEN
        Person result = personService.getPerson("Adina");

        //THEN
        Assertions.assertThat(result).isEqualTo(person2);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasNoNullFieldsOrProperties();
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            personService.getPerson("Florin");
        });
    }

    @Test
    public void testGetPersonById() {
        //GIVEN
        PersonService personService = new PersonService(new LinkedList<>());
        Person person1 = new Person(20, "Alina");
        Person person2 = new Person(22, "Adina");
        Person person3 = new Person(27, "Denisa");
        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);


        //WHEN
        Person result = personService.getPersonById(2);

        //THEN
        Assertions.assertThat(result).isEqualTo(person2);
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result).hasNoNullFieldsOrProperties();
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            personService.getPersonById(10);
        });
    }
}
