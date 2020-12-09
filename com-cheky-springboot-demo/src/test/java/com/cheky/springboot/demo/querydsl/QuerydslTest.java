package com.cheky.springboot.demo.querydsl;

import com.cheky.springboot.demo.dao.BaseUserDAOTest;
import com.cheky.springboot.demo.model.QUserDO;
import com.cheky.springboot.demo.model.UserDO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class QuerydslTest extends BaseUserDAOTest {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    @Transactional
    public void testQuerydslSample() {
        QUserDO qUser = QUserDO.userDO;
        UserDO user = this.jpaQueryFactory.select(qUser).from(qUser).where(qUser.id.eq(1)).fetchFirst();
        System.out.println(user);
    }
}