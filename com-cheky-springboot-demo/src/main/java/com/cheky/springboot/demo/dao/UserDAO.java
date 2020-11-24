package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<UserDO, Integer>, JpaSpecificationExecutor<UserDO> {

    /**
     * 查询 使用jpql 依据lastName 找到User
     * @param lastName
     * @return user
     */
    @Query(value = "from UserDO where lastName = ?1")
    UserDO findOneByName(String lastName);


    /**
     * 查询 使用jpql 依据lastName 和 Id 找到User
     * @param lastName
     * @param id
     * @return
     */
    @Query(value = "from UserDO where lastName = ?1 and id=?2")
    UserDO findOneByNameAndId(String lastName, Integer id);

    /**
     * 更新 使用jpql 依据id 更新lastName
     * @param id
     * @param lastName
     * @return
     */
    @Query(value = "update UserDO set lastName=?2 where id=?1")
    @Modifying
    Integer updateUser(Integer id, String lastName);

    /**
     * 查询 使用spring-data-jpa 依据lastName 找到User
     * 自动依据方法名称解析生成 jpql
     * @param name
     * @return user
     */
    UserDO findByLastName(String name);

    /**
     * 查询 使用spring-data-jpa 依据lastName模糊匹配 找到Users
     * 自动依据方法名称解析生成 jpql
     * @param name
     * @return list
     */
    List<UserDO> findByLastNameLike(String name);

    /**
     * 查询 使用spring-data-jpa 依据lastName精确查询 和 email 和 找到Users
     * 自动依据方法名称解析生成 jpql
     * @param name
     * @param mail
     * @return
     */
    List<UserDO> findByLastNameAndEmailLike(String name, String mail);
}
