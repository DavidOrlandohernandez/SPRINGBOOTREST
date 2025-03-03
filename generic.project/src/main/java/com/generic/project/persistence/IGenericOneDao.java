package com.generic.project.persistence;

import com.generic.project.entities.GenericOne;

import java.util.List;
import java.util.Optional;

public interface IGenericOneDao {

    List<GenericOne> findAll();

    Optional<GenericOne> findById(int id);

    void save(GenericOne genericOne);

    void deleteById(int id);
}
