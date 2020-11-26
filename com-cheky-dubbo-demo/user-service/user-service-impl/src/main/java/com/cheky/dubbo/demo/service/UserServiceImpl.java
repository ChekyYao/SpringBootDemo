package com.cheky.dubbo.demo.service;

import com.cheky.dubbo.demo.dao.UserDAO;
import com.cheky.dubbo.demo.dto.UserDTO;
import com.cheky.dubbo.demo.model.UserDO;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cheky
 * @date 2020-11-26
 */
@RequiredArgsConstructor
@DubboService
public class UserServiceImpl implements UserService{

    private final UserDAO dao;

    @Override
    public List<UserDTO> findAll() {
        final List<UserDO> dataList = dao.findAll();

        return dataList.stream().map(data -> {
            final UserDTO dto = new UserDTO();
            dto.setId(data.getId());
            dto.setLastName(data.getLastName());
            dto.setEmail(data.getEmail());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(final Integer id) {
        var data = dao.findById(id).get();
        final UserDTO dto = new UserDTO();
        dto.setId(data.getId());
        dto.setLastName(data.getLastName());
        dto.setEmail(data.getEmail());
        return dto;
    }

    @Override
    public void insert(final UserDTO dto) {
        final var user = new UserDO();
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        dao.save(user);
    }

    @Override
    public void update(final UserDTO dto) {
        var user = new UserDO();
        user.setId(dto.getId());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        dao.save(user);
    }

    @Override
    public void deleteById(final Integer id) {
        dao.deleteById(id);
    }
}
