package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    /**
     * 查询 使用jpql 依据lastName 找到User
     * @param lastName
     * @return user
     */
    @Query(value = "from User where lastName = ?1")
    User findOneByName(String lastName);


    /**
     * 查询 使用jpql 依据lastName 和 Id 找到User
     * @param lastName
     * @param id
     * @return
     */
    @Query(value = "from User where lastName = ?1 and id=?2")
    User findOneByNameAndId(String lastName, Integer id);

    /**
     * 更新 使用jpql 依据id 更新lastName
     * @param id
     * @param lastName
     * @return
     */
    @Query(value = "update User set lastName=?2 where id=?1")
    @Modifying
    Integer updateUser(Integer id, String lastName);

    /**
     * 查询 使用spring-data-jpa 依据lastName 找到User
     * 自动依据方法名称解析生成 jpql
     * @param name
     * @return user
     */
    User findByLastName(String name);

    /**
     * 查询 使用spring-data-jpa 依据lastName模糊匹配 找到Users
     * 自动依据方法名称解析生成 jpql
     * @param name
     * @return list
     */
    List<User> findByLastNameLike(String name);

    /**
     * 查询 使用spring-data-jpa 依据lastName精确查询 和 email 和 找到Users
     * 自动依据方法名称解析生成 jpql
     * @param name
     * @param mail
     * @return
     */
    List<User> findByLastNameAndEmailLike(String name, String mail);
}
