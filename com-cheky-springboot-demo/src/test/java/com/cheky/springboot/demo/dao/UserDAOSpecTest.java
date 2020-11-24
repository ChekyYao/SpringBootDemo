package com.cheky.springboot.demo.dao;

import com.cheky.springboot.demo.model.UserDO;
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
public class UserDAOSpecTest {

    @Autowired
    private UserDAO userDAO;

    //查询
    @Test
    public void testFindViaSpec() {
        List<UserDO> users = userDAO.findAll(new Specification<UserDO>() {
            @Override
            public Predicate toPredicate(Root<UserDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                var email = root.get("email");
                Predicate predicateEmail = criteriaBuilder.equal(email, "1@1.com");
                Path<String> lastName = root.get("lastName");
                var predicateLastName = criteriaBuilder.like(lastName,"J%");
                var predicate = criteriaBuilder.and(predicateEmail,predicateLastName);
                return predicate;
            }
        });

        printUsers(users);
    }

    //排序
    @Test
    public void testFindWithSort() {
        var users= userDAO.findAll(Sort.by(Sort.Direction.DESC, "lastName"));
        printUsers(users);
    }

    //分页
    @Test
    public void testFindWithPage() {
        var pageRequest = PageRequest.of(0,2);
        var pageResult = userDAO.findAll(pageRequest);
        printUsers(pageResult.getContent());
        System.out.println("total count of elements in db = " + pageResult.getTotalElements());
        System.out.println("total count of elements in current page = " + pageResult.getNumberOfElements());
        System.out.println("total pages = " + pageRequest.getPageSize());
    }

    private void printUsers(List<? extends Object> objects) {
        for (var object : objects){
            System.out.println(object);
        }
    }
}
