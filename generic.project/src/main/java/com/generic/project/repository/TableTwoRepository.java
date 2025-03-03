package com.generic.project.repository;

import com.generic.project.entities.GenericTwo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTwoRepository extends CrudRepository<GenericTwo, Integer> {
}
