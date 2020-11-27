package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.common.UserCommon;
import com.cheky.springboot.demo.model.UserDO;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserDAOTest extends BaseUserDAOTest {

    @Test
    public void testFindAll(){
        var users = userDAO.findAll();
        assert users.size() > 0;
        for (var user: users)
        {
            assert user != null;
        }
    }

    @Test
    public void testFindOne(){
        var user = userDAO.findById(userDO.getId());
        assert user != null;
    }

    @Test
    public void testCount(){
        var count = userDAO.count();
        assert count > 0L;
    }

    @Test
    @Transactional //因为延迟加载，所以需要在同个事务中进行测试
    public void testGetOne(){
        UserDO one = userDAO.getOne(userDO.getId());//延迟加载，即使用的时候才会加载；用的是JDBC 的 EM.GetReference()
        assert one != null;
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateUser() {
        var count = userDAO.updateUser(userDO.getId(), "hello");
        assert count == 1;
    }
}
