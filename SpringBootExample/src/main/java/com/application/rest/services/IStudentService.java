package com.application.rest.services;

import com.application.rest.entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> findAll();

    Optional<Student> findById(int id);

    void save(Student student);

    void deleteById(int id);
}
