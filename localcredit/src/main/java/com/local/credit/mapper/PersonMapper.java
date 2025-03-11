package com.local.credit.mapper;

import com.local.credit.controller.dto.PersonCustomDto;
import com.local.credit.controller.dto.PersonDefaultDto;
import com.local.credit.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDefaultDto personToPersonDefaultDto(Person person);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "name", target = "nameDto")
    @Mapping(source = "lastName", target = "lastNameDto")
    @Mapping(source = "email", target = "emailDto")
    @Mapping(source = "age", target = "ageDto")
    @Mapping(source = "gender", target = "genderDto")
    PersonCustomDto personToPersonCustomDto(Person person);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "name", target = "nameDto")
    @Mapping(source = "lastName", target = "lastNameDto")
    @Mapping(source = "email", target = "emailDto")
    @Mapping(source = "age", target = "ageDto")
    @Mapping(source = "gender", target = "genderDto")
    List<PersonCustomDto> personsToPersonsCustomDto(List<Person> person);

}
