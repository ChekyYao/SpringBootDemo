package com.cheky.dubbo.demo.service;


import com.cheky.dubbo.demo.dto.UserDTO;

import java.util.List;

/**
 * @author Cheky
 */
public interface UserService {
    /**
     * 查找所有 Users
     * @return
     */
    List<UserDTO> findAll();

    /**
     * 根据 id 找到 对于的User
     * @param id
     * @return
     */
    UserDTO findById(Integer id);

    /**
     * 新增 User
     * @param dto
     */
    void insert(UserDTO dto);

    /**
     * 更新 User
     * @param user
     */
    void update(UserDTO dto);

    /**
     * 根据 id 删除 User
     * @param id
     */
    void deleteById(Integer id);
}
