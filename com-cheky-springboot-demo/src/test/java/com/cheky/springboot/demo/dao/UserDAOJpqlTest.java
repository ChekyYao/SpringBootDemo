package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.common.UserCommon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOJpqlTest extends BaseUserDAOTest {

    @Test
    public void testFindOneByName(){
        var one = userDAO.findOneByName("Cheky");
        assert one != null;
    }

    @Test
    public void testFindOneByNameAndId(){
        var one = userDAO.findOneByNameAndId("Cheky", userDO.getId());
        assert one != null;
    }

    @Test
    public void testFindByLastName(){
        var one = userDAO.findByLastName("Cheky");
        assert one != null;
    }

    @Test
    public void testFindByLastNameLike(){
        var users = userDAO.findByLastNameLike("C%");
        assert users.size() > 0;
    }

    @Test
    public void testFindByLastNameAndEmailLike(){
        var users = userDAO.findByLastNameAndEmailLike("Cheky", "1%");
        assert users.size() > 0;
    }

    //https://www.bilibili.com/video/BV1vW411M7zp?p=23
    //SubQuery
    //Function
}
