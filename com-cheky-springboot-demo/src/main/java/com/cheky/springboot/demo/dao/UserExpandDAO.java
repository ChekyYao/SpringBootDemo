package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.UserExpandDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Cheky
 */
public interface UserExpandDAO extends JpaRepository<UserExpandDO, Long>, JpaSpecificationExecutor<UserExpandDO> {}
