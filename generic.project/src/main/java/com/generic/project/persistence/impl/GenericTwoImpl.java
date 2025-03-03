package com.generic.project.persistence.impl;

import com.generic.project.entities.GenericTwo;
import com.generic.project.persistence.IGenericTwoDao;
import com.generic.project.repository.TableTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GenericTwoImpl implements IGenericTwoDao {

    @Autowired
    private TableTwoRepository tableTwoRepository;

    @Override
    public List<GenericTwo> findAll() {
        return (List<GenericTwo>) tableTwoRepository.findAll();
    }

    @Override
    public Optional<GenericTwo> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(GenericTwo genericTwo) {
        tableTwoRepository.save(genericTwo);
    }

    @Override
    public void deleteById(int id) {

    }
}
