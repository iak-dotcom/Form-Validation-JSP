package com.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validation.entities.User;

public interface ValidationRepository extends JpaRepository<User, Long> {

}
