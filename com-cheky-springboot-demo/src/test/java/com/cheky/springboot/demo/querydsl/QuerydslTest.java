package com.cheky.springboot.demo.querydsl;

import com.cheky.springboot.demo.dao.BaseUserDAOTest;
import com.cheky.springboot.demo.model.QUserDO;
import com.cheky.springboot.demo.model.QUserExpandDO;
import com.cheky.springboot.demo.model.UserDO;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Cheky
 * @date 2020-12-09
 *
 * Querydsl 用起来的感觉 就是 函数式编程
 * 主要的查询方法 如下 单元测试
 * 其他功能： 删除，更新，子查询 详见官方文档 http://www.querydsl.com/static/querydsl/4.4.0/reference/html_single/#d0e101
 */
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

    @Test
    @Transactional
    public void testQuerySingleColumn() {
        QUserDO qUser = QUserDO.userDO;
        var result = this.jpaQueryFactory.select(qUser.email).from(qUser).fetch();
        result.forEach(x -> System.out.println(x));
    }

    @Test
    @Transactional
    public void testQueryMultipleColumn() {
        QUserDO qUser = QUserDO.userDO;
        List<Tuple> result = this.jpaQueryFactory.select(qUser.email, qUser.lastName).from(qUser).fetch();
        result.forEach(x -> System.out.println(x));
    }

    @Test
    @Transactional
    public void testQueryWithJoin() {
        QUserDO qUser = QUserDO.userDO;
        QUserExpandDO qUserExpandDO = QUserExpandDO.userExpandDO;
        var result = this.jpaQueryFactory.select(qUser).from(qUser).
                innerJoin(qUserExpandDO).on(qUser.email.eq(qUserExpandDO.lastLoginPlace)).fetch();
        assert result.size() == 0;

        result = this.jpaQueryFactory.select(qUser).from(qUser).
                leftJoin(qUserExpandDO).on(qUser.email.eq(qUserExpandDO.lastLoginPlace)).fetch();
        assert result.size() == 1;
    }

    @Test
    @Transactional
    public void testQueryWithAnd() {
        QUserDO qUser = QUserDO.userDO;
        //写法1
        var result = jpaQueryFactory.select(qUser).from(qUser).
                where(qUser.email.eq("139@163.com").and(qUser.lastName.eq("Cheky"))).fetch();
        assert result.size() == 1;

        //写法2
        result = jpaQueryFactory.select(qUser).from(qUser).
                where(qUser.email.eq("139@163.com"), qUser.lastName.eq("Cheky")).fetch();
        assert result.size() == 1;
    }

    @Test
    @Transactional
    public void testQueryWithOr() {
        QUserDO qUser = QUserDO.userDO;
        var result = jpaQueryFactory.select(qUser).from(qUser).
                where(qUser.email.eq("139@163.com").or(qUser.lastName.eq("!!!!Cheky"))).fetch();
        assert result.size() == 1;
    }

    @Test
    @Transactional
    public void testQueryWithOrderBy() {
        QUserDO qUser = QUserDO.userDO;
        var result = jpaQueryFactory.select(qUser).from(qUser).
                orderBy(qUser.email.asc(), qUser.birthDate.desc()).fetch();
        assert result.size() == 1;
    }

    @Test
    @Transactional
    public void testQueryWithGroupBy() {
        QUserDO qUser = QUserDO.userDO;
        var result = jpaQueryFactory.select(qUser.count(),qUser.lastName).from(qUser).
                groupBy(qUser.lastName).fetch();
        result.forEach(x -> System.out.println(x));
    }
}