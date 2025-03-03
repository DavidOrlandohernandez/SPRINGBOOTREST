package com.generic.project.service;

import com.generic.project.entities.GenericOne;

import java.util.List;
import java.util.Optional;

public interface IGenericOneService {
    List<GenericOne> findAll();

    Optional<GenericOne> findById(int id);

    void save(GenericOne genericOne);

    void deleteById(int id);
}
