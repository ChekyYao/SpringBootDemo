package com.cheky.springboot.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOJpqlTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindOneByName(){
        var one = userDAO.findOneByName("JPA");
        System.out.println("one = " + one);
    }

    @Test
    public void testFindOneByNameAndId(){
        var one = userDAO.findOneByNameAndId("JPA", 3);
        System.out.println("one = " + one);
    }

    @Test
    public void testFindByLastName(){
        var one = userDAO.findByLastName("JPA");
        System.out.println("one = " + one);
    }

    @Test
    public void testFindByLastNameLike(){
        var users = userDAO.findByLastNameLike("J%");
        for(var user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByLastNameAndEmailLike(){
        var users = userDAO.findByLastNameAndEmailLike("JPA", "1%");
        for(var user : users) {
            System.out.println(user);
        }
    }
}
