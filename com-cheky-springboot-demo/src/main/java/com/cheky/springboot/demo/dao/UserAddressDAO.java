package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.UserAddressDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Cheky
 */
public interface UserAddressDAO extends JpaRepository<UserAddressDO, Long>, JpaSpecificationExecutor<UserAddressDO> {}
