package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDAO extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
}
