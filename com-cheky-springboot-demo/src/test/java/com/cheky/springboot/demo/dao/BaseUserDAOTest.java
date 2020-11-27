package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.common.UserCommon;
import com.cheky.springboot.demo.model.UserDO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BaseUserDAOTest {
    @Autowired
    protected UserDAO userDAO;

    protected UserCommon common;
    protected UserDO userDO;
    @BeforeEach
    private void initializeData() {
        common = new UserCommon(userDAO);
        userDO = common.createUser();
    }

    @AfterEach
    @Transactional
    @Rollback(value = false)
    private void disposeData(){
        var user = userDAO.findById(userDO.getId());
        if(!user.isEmpty()){
            userDAO.delete(user.get());
        }
    }
}
