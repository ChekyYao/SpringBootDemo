package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.common.UserCommon;
import com.cheky.springboot.demo.model.RoleDO;
import com.cheky.springboot.demo.model.UserDO;
import com.cheky.springboot.demo.model.UserAddressDO;
import com.cheky.springboot.demo.model.UserExpandDO;
import lombok.NonNull;
import org.junit.jupiter.api.BeforeEach;
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
public class UserDAOErpTest extends BaseUserDAOTest {

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
    public void testOneToOne() {
        var user = userDO;
        var userExpand = common.createUserExpand(user);
        final var userSaved = userDAO.save(user);
        assert userSaved != null;
        final var userExpandSaved = userExpandDAO.save(userExpand);
        assert userExpandSaved != null;
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToOneForDelete() {
        // 级联删除:方法1
        // var user = userDAO.findById(userDO.getId()).get();
        // userDAO.delete(user);

        // 级联删除：方法2
        userDAO.deleteById(userDO.getId());
    }

    // 1:N 和 N:1 涉及放弃维护权
    // 级联操作 和 非级联操作
    @Test
    @Transactional
    public void testOneToManyForAdd() {
        var user = userDO;
        var address = common.createAddress(user);
        final var userSaved = userDAO.save(user);
        assert userSaved != null;
        final var userAddressSaved = userAddressDAO.save(address);
        assert userAddressSaved != null;
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testOneToManyForDelete() {
        // 级联删除:方法1
        // var user = userDAO.findById(userDO.getId()).get();
        // userDAO.delete(user);

        // 级联删除：方法2
        userDAO.deleteById(userDO.getId());
    }

    // N:M 涉及放弃维护权
    // 级联操作 和 非级联操作
    @Test
    @Transactional
    @Rollback(value = false)
    public void testManyToManyForAdd() {
        var user = userDO;
        var role = common.createRole(user);
        final var userSaved = userDAO.save(user);
        assert userSaved != null;
        final var userRoleSaved = roleDAO.save(role);
        assert userRoleSaved != null;
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testManyToManyForDelete() {
        // 级联删除:方法1
        // var user = userDAO.findById(userDO.getId()).get();
        // userDAO.delete(user);

        // 级联删除：方法2
        userDAO.deleteById(userDO.getId());
    }

    @Test
    @Transactional
    public void testAllErpForAdd() {
        var user = userDO;
        var role = common.createRole(user);
        var address = common.createAddress(user);
        var userExpand = common.createUserExpand(user);
        final var userSaved = userDAO.save(user);
        assert userSaved != null;
        final var userRoleSaved = roleDAO.save(role);
        assert userRoleSaved != null;
        final var userAddressSaved = userAddressDAO.save(address);
        assert userAddressSaved != null;
        final var userExpandSaved = userExpandDAO.save(userExpand);
        assert userExpandSaved != null;
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAllErpForDelete() {
        userDAO.deleteById(userDO.getId());
    }
}
