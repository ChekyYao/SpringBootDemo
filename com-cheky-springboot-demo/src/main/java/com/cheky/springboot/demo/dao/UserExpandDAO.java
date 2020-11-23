package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.entity.User;
import com.cheky.springboot.demo.entity.UserExpand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Cheky
 */
public interface UserExpandDAO extends JpaRepository<UserExpand, Long>, JpaSpecificationExecutor<UserExpand> {}
