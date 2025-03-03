package com.application.rest.services.impl;

import com.application.rest.entities.Student;
import com.application.rest.persistence.IStudentDAO;
import com.application.rest.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        //ITS type T
        return (List<Student>) studentDAO.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }
}
