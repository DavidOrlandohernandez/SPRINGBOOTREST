package com.local.credit.mapper;

import com.local.credit.LocalCreditApplication;
import com.local.credit.controller.dto.PersonCustomDto;
import com.local.credit.controller.dto.PersonDefaultDto;
import com.local.credit.entities.Person;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person3 = new Person(1L, "David Orlando", "Hernandez","davd@gmail.com", (byte)31, 'M');
        System.out.println(person3);

        PersonDefaultDto personDefaultDto1 = PersonMapper.INSTANCE.personToPersonDefaultDto(person3);
        System.out.println(personDefaultDto1.toString());

        PersonCustomDto personCustomDto = PersonMapper.INSTANCE.personToPersonCustomDto(person3);
        System.out.println(personCustomDto);

        List<Person> personList = new ArrayList<>();
        Person person4 = new Person(4L, "David Alexander", "Bastidas","Alexander@gmail.com", (byte)5, 'M');
        Person person5 = new Person(5L, "Sthepahny", "Gastelum","Stheph@gmail.com", (byte)27, 'F');
        Person person6 = new Person(6L, "Ari", "Inzuna","Ari@gmail.com", (byte)21, 'F');

        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        List<PersonCustomDto> personCustomDtos = PersonMapper.INSTANCE.personsToPersonsCustomDto(personList);
        System.out.println(personCustomDtos);

    }
}
