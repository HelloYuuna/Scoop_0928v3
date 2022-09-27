package com.example.scoop.repository;

import java.util.Optional;

import com.example.scoop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

   Optional<User> findByEmail(String email);
   
}