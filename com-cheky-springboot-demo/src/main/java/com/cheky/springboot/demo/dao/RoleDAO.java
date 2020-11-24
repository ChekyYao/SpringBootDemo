package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Cheky
 */
public interface RoleDAO extends JpaRepository<RoleDO, Long>, JpaSpecificationExecutor<RoleDO> {}
