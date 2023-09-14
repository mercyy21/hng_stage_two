package com.example.demo.dao;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    //@Query("SELECT u FROM User u WHERE u.id = :identifier OR u.name = :identifier")
    //UserEntity findByIdentifier(@Param("identifier") String identifier);

    UserEntity findByName(String name);
}

