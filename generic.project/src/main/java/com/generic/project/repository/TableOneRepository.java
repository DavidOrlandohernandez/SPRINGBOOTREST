package com.generic.project.repository;

import com.generic.project.entities.GenericOne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableOneRepository extends CrudRepository<GenericOne, Integer> {
}
