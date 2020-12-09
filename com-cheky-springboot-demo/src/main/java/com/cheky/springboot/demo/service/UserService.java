package com.cheky.springboot.demo.service;

import com.cheky.springboot.demo.dao.UserDAO;
import com.cheky.springboot.demo.dto.UserDTO;
import com.cheky.springboot.demo.model.UserDO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserDAO dao;

    private JPAQueryFactory queryFactory;

    public List<UserDTO> findAll() {
        final List<UserDO> dataList = dao.findAll();
        return dataList.stream().map(data -> ConvertDOtoDTO(data)).collect(Collectors.toList());
    }

    public UserDTO findById(final Integer id) {

        final Optional<UserDO> data = dao.findById(id);

        if (data.isEmpty()) {
            return null;
        }
        return ConvertDOtoDTO(data.get());
    }

    public void insert(final UserDTO dto) {

        final UserDO data = new UserDO();
        data.setEmail(dto.getEmail());
        data.setLastName(dto.getLastName());
        dao.save(data);
    }

    public void update(final UserDTO dto) {
        var id = dto.getId();
        final Optional<UserDO> data = dao.findById(id);
        if (!data.isEmpty()) {
            var user = data.get();
            user.setEmail(dto.getEmail());
            user.setLastName(dto.getLastName());
            dao.save(user);
        }
    }

    public void deleteById(final Integer id) {
        dao.deleteById(id);
    }

    private UserDTO ConvertDOtoDTO(UserDO data) {
        final UserDTO dto = new UserDTO();
        dto.setId(data.getId());
        dto.setEmail(data.getEmail());
        dto.setLastName(data.getLastName());
        return dto;
    }
}
