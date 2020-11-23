package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.entity.Role;
import com.cheky.springboot.demo.entity.User;
import com.cheky.springboot.demo.entity.UserAddress;
import com.cheky.springboot.demo.entity.UserExpand;
import com.cheky.springboot.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/**
 * ERP 关系处理
 */
@SpringBootTest
public class UserDAOErpTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserExpandDAO userExpandDAO;

    @Autowired
    private UserAddressDAO userAddressDAO;

    @Autowired
    private RoleDAO roleDAO;

    // 1:1 涉及 放弃维护权
    // 级联操作 和 非级联操作
    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToOne() {
        var user = new User();
        user.setLastName("Cheky");
        user.setEmail("139@163.com");
        var userExpand = new UserExpand();
        userExpand.setLastLoginDate(new Date());
        userExpand.setLastLoginPlace("SZX");
        userExpand.setUser(user);
        //user.setUserExpand(userExpand); // 放弃了维护权后，这里设定外键将不会生效
        System.out.println("user = " + user);
        System.out.println("userExpand = " + userExpand);
        final var userSaved = userDAO.save(user);
        System.out.println("userSaved = " + userSaved);
        final var userExpandSaved = userExpandDAO.save(userExpand);
        System.out.println("userExpandSaved = " + userExpandSaved);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToOneForDelete() {
        System.out.println("级联删除:方法1");
        var user = userDAO.findById(9).get();
        userDAO.delete(user);

        System.out.println("级联删除：方法2");
        userDAO.deleteById(10);
    }

    // 1:N 和 N:1 涉及放弃维护权
    // 级联操作 和 非级联操作
    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToManyForAdd() {
        var user = new User();
        user.setLastName("Cheky");
        user.setEmail("139@163.com");
        var address = new UserAddress();
        address.setAddress("SZX Address");
        address.setUser(user);
        //user.getUserAddresses().add(address); // 放弃了维护权后，这里设定外键将不会生效
        System.out.println("user = " + user);
        System.out.println("address = " + address);
        final var userSaved = userDAO.save(user);
        System.out.println("userSaved = " + userSaved);
        final var userAddressSaved = userAddressDAO.save(address);
        System.out.println("userAddressSaved = " + userAddressSaved);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToManyForDelete() {
        System.out.println("级联删除:方法1");
        var user = userDAO.findById(6).get();
        userDAO.delete(user);

        System.out.println("级联删除：方法2");
        userDAO.deleteById(7);
    }

    // N:M 涉及放弃维护权
    // 级联操作 和 非级联操作
    @Test
    @Transactional
    @Rollback(value = false)
    public void testManyToManyForAdd() {
        var user = new User();
        user.setLastName("Cheky");
        user.setEmail("139@163.com");
        var role = new Role();
        role.setRoleName("Admin");
        user.getRoles().add(role);
        //role.getUsers().add(user); // 放弃了维护权后，这里设定外键将不会生效
        System.out.println("user = " + user);
        System.out.println("role = " + role);
        final var userSaved = userDAO.save(user);
        System.out.println("userSaved = " + userSaved);
        final var userRoleSaved = roleDAO.save(role);
        System.out.println("userRoleSaved = " + userRoleSaved);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testManyToManyForDelete() {
        System.out.println("级联删除:方法1");
        var user = userDAO.findById(11).get();
        userDAO.delete(user);

        System.out.println("级联删除：方法2");
        userDAO.deleteById(12);
    }
}
