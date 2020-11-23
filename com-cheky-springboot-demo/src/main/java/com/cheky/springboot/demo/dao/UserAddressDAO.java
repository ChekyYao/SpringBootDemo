package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.entity.UserAddress;
import com.cheky.springboot.demo.entity.UserExpand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Cheky
 */
public interface UserAddressDAO extends JpaRepository<UserAddress, Long>, JpaSpecificationExecutor<UserAddress> {}
