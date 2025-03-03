package com.application.rest.persistence;

import com.application.rest.entities.Student;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface IStudentDAO{

    List<Student> findAll();

    Optional<Student> findById(int id);

    void save(Student student);

    void deleteById(int id);

}
