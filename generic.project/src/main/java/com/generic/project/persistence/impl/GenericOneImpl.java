package com.generic.project.persistence.impl;

import com.generic.project.entities.GenericOne;
import com.generic.project.persistence.IGenericOneDao;
import com.generic.project.repository.TableOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GenericOneImpl implements IGenericOneDao {

    @Autowired
    private TableOneRepository tableOneRepository;

    @Override
    public List<GenericOne> findAll() {
        return (List<GenericOne>) tableOneRepository.findAll();
    }

    @Override
    public Optional<GenericOne> findById(int id) {
        return tableOneRepository.findById(id);
    }

    @Override
    public void save(GenericOne genericOne) {
        tableOneRepository.save(genericOne);
    }

    @Override
    public void deleteById(int id) {
        tableOneRepository.findById(id);
    }
}
