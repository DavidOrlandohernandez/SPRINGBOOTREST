package com.generic.project.service.impl;

import com.generic.project.entities.GenericOne;
import com.generic.project.persistence.IGenericOneDao;
import com.generic.project.service.IGenericOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenericOneServiceImpl implements IGenericOneService {

    @Autowired
    private IGenericOneDao genericOneDao;

    @Override
    public List<GenericOne> findAll() {
        return genericOneDao.findAll();
    }

    @Override
    public Optional<GenericOne> findById(int id) {
        return genericOneDao.findById(id);
    }

    @Override
    public void save(GenericOne genericOne) {
        genericOneDao.save(genericOne);
    }

    @Override
    public void deleteById(int id) {
        genericOneDao.deleteById(id);
    }
}
