package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.PersonRelationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Cheky
 */
public interface PersonRelationDAO extends JpaRepository<PersonRelationDO, Long>, JpaSpecificationExecutor<PersonRelationDO> {}
