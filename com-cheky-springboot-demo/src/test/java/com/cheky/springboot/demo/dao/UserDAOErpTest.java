package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.RoleDO;
import com.cheky.springboot.demo.model.UserDO;
import com.cheky.springboot.demo.model.UserAddressDO;
import com.cheky.springboot.demo.model.UserExpandDO;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        var user = createUser();
        var userExpand = createUserExpand(user);
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
        var user = createUser();
        var address = createAddress(user);
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
        var user = createUser();
        var role = createRole(user);
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

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAllErpForAdd() {
        var user = createUser();
        var role = createRole(user);
        var address = createAddress(user);
        var userExpand = createUserExpand(user);
        final var userSaved = userDAO.save(user);
        System.out.println("userSaved = " + userSaved);
        final var userRoleSaved = roleDAO.save(role);
        System.out.println("userRoleSaved = " + userRoleSaved);
        final var userAddressSaved = userAddressDAO.save(address);
        System.out.println("userAddressSaved = " + userAddressSaved);
        final var userExpandSaved = userExpandDAO.save(userExpand);
        System.out.println("userExpandSaved = " + userExpandSaved);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAllErpForDelete() {
        userDAO.deleteById(14);
    }

    private UserDO createUser(){
        var user = new UserDO();
        user.setLastName("Cheky");
        user.setEmail("139@163.com");
        return user;
    }

    private RoleDO createRole(@NonNull UserDO user) {
        var role = new RoleDO();
        role.setRoleName("Admin");
        user.getRoles().add(role);
        //role.getUsers().add(user); // 放弃了维护权后，这里设定外键将不会生效
        return role;
    }

    private UserAddressDO createAddress(@NonNull UserDO user) {
        var address = new UserAddressDO();
        address.setAddress("SZX Address");
        address.setUser(user);
        //user.getUserAddresses().add(address); // 放弃了维护权后，这里设定外键将不会生效
        return address;
    }

    private UserExpandDO createUserExpand(@NonNull UserDO user) {
        var userExpand = new UserExpandDO();
        userExpand.setLastLoginDate(new Date());
        userExpand.setLastLoginPlace("SZX");
        userExpand.setUser(user);
        //user.setUserExpand(userExpand); // 放弃了维护权后，这里设定外键将不会生效
        return userExpand;
    }
}
