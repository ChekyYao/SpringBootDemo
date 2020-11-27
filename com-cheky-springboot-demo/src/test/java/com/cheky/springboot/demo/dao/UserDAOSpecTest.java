package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.common.UserCommon;
import com.cheky.springboot.demo.model.UserDO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * 动态条件处理
 */
@SpringBootTest
public class UserDAOSpecTest extends BaseUserDAOTest{
    //查询
    @Test
    public void testFindViaSpec() {
        List<UserDO> users = userDAO.findAll(new Specification<UserDO>() {
            @Override
            public Predicate toPredicate(Root<UserDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                var email = root.get("email");
                Predicate predicateEmail = criteriaBuilder.equal(email, "139@163.com");
                Path<String> lastName = root.get("lastName");
                var predicateLastName = criteriaBuilder.like(lastName,"C%");
                var predicate = criteriaBuilder.and(predicateEmail,predicateLastName);
                return predicate;
            }
        });

        assert users.size() > 0;
    }

    //排序
    @Test
    public void testFindWithSort() {
        var users= userDAO.findAll(Sort.by(Sort.Direction.DESC, "lastName"));
        assert users.size() > 0;
    }

    //分页
    @Test
    public void testFindWithPage() {
        var pageRequest = PageRequest.of(0,2);
        var pageResult = userDAO.findAll(pageRequest);
        assert pageResult.getNumberOfElements() < 3;
    }
}
