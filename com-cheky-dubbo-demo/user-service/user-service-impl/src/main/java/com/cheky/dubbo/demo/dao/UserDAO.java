package com.cheky.dubbo.demo.dao;

import com.cheky.dubbo.demo.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User DAO
 * @author Cheky
 * @date 2020-11-26
 */
public interface UserDAO extends JpaRepository<UserDO, Integer> {
}
