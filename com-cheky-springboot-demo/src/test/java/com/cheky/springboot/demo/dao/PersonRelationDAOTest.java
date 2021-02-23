package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.PersonRelationDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonRelationDAOTest {
    @Autowired
    protected PersonRelationDAO personRelationDAO;

    @Test
    public void testInsertAndUpdatePersonRelation() {
        var person = new PersonRelationDO();
        person.setName("ZhangSan");
        person = personRelationDAO.save(person);
        assert person.getCreateAt() != null;
        assert person.getUpdateAt() == null;

        person.setName("ZhangSan2");
        person = personRelationDAO.save(person);
        assert person.getCreateAt() != null;
        assert person.getUpdateAt() != null;
    }
}
