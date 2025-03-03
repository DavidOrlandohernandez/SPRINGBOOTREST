package com.application.rest.persistence.impl;

import com.application.rest.entities.Student;
import com.application.rest.persistence.IStudentDAO;
import com.application.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDAOImpl implements IStudentDAO {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        //ITS type T
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById((long)id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById((long)id);
    }
}
