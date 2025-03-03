package com.app.persistence.repository;

import com.app.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


    //QUERYMETHOD
    Optional<UserEntity> findUserEntityByUsername(String username);

    //QUERY NOTACION
    //@Query("SELECT U FROM UserEntity U WHERE U.username = ?")
    //Optional<UserEntity> findUser(String username);
}
