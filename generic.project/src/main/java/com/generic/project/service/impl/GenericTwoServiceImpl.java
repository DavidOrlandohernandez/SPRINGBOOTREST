package com.generic.project.service.impl;

import com.generic.project.entities.GenericTwo;
import com.generic.project.persistence.IGenericTwoDao;
import com.generic.project.service.IGenericTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenericTwoServiceImpl implements IGenericTwoService {

    @Autowired
    private IGenericTwoDao genericTwoDao;

    @Override
    public List<GenericTwo> findAll() {
        return genericTwoDao.findAll();
    }

    @Override
    public Optional<GenericTwo> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(GenericTwo genericTwo) {
        genericTwoDao.save(genericTwo);
    }

    @Override
    public void deleteById(int id) {

    }
}
