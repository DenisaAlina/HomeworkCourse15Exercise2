package com.fasttrackit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PersonTest {


    @Test
    public void instantiateNewPersonWithNullName(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            new Person( 10, null);
        });
    }

    @Test
    public void instantiateNewPersonWithNegativeAge(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            new Person( -10, "Denisa");
        });
    }

    @Test
    public void instantiateNewPersonWithAgeGreaterThan120(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            new Person( 130, "Denisa");
        });
    }

    @Test
    public void instantiatePersonIfFieldsNotNull(){

        //GIVEN
        Integer age = 27;
        String name= "Denisa Alina";

        //WHEN
        Person person= new Person(age, name );

        //THEN
        org.assertj.core.api. Assertions.assertThat(person.getAge()).isEqualTo(27);
        org.assertj.core.api. Assertions.assertThat(person.getName()).isEqualTo("Denisa Alina");


    }

}
