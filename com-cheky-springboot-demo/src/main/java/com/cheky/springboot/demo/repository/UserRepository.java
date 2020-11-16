package com.cheky.springboot.demo.repository;

import com.cheky.springboot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}