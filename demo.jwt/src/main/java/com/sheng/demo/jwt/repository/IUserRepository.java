package com.sheng.demo.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheng.demo.jwt.models.User;

public interface IUserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
}
