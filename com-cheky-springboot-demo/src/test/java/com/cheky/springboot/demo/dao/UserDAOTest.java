package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindAll(){
        var users = userDAO.findAll();
        for (var user: users)
        {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testFindOne(){
        var user = userDAO.findById(1);
        System.out.println("user = " + user);
    }

    @Test
    public void testCount(){
        long count = userDAO.count();
        System.out.println("count = " + count);
    }

    @Test
    @Transactional //因为延迟加载，所以需要在同个事务中进行测试
    public void testGetOne(){
        User one = userDAO.getOne(1);//延迟加载，即使用的时候才会加载；用的是JDBC 的 EM.GetReference()
        System.out.println("one = " + one);
    }
}
