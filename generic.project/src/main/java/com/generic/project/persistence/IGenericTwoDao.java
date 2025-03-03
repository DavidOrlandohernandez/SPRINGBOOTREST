package com.generic.project.persistence;

import com.generic.project.entities.GenericTwo;

import java.util.List;
import java.util.Optional;

public interface IGenericTwoDao {

    List<GenericTwo> findAll();

    Optional<GenericTwo> findById(int id);

    void save(GenericTwo genericTwo);

    void deleteById(int id);
}
