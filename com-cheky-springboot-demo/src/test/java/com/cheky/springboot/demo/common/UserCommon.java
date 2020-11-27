package com.cheky.springboot.demo.common;

import com.cheky.springboot.demo.dao.UserDAO;
import com.cheky.springboot.demo.model.RoleDO;
import com.cheky.springboot.demo.model.UserAddressDO;
import com.cheky.springboot.demo.model.UserDO;
import com.cheky.springboot.demo.model.UserExpandDO;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@AllArgsConstructor
public class UserCommon {
    private UserDAO userDAO;

    @Transactional
    @Rollback(value = false)
    public UserDO createUser(){
        var user = new UserDO();
        user.setLastName("Cheky");
        user.setEmail("139@163.com");
        return userDAO.save(user);
    }

    public RoleDO createRole(@NonNull UserDO user) {
        var role = new RoleDO();
        role.setRoleName("Admin");
        user.getRoles().add(role);
        //role.getUsers().add(user); // 放弃了维护权后，这里设定外键将不会生效
        return role;
    }

    public UserAddressDO createAddress(@NonNull UserDO user) {
        var address = new UserAddressDO();
        address.setAddress("SZX Address");
        address.setUser(user);
        //user.getUserAddresses().add(address); // 放弃了维护权后，这里设定外键将不会生效
        return address;
    }

    public UserExpandDO createUserExpand(@NonNull UserDO user) {
        var userExpand = new UserExpandDO();
        userExpand.setLastLoginDate(new Date());
        userExpand.setLastLoginPlace("SZX");
        userExpand.setUser(user);
        //user.setUserExpand(userExpand); // 放弃了维护权后，这里设定外键将不会生效
        return userExpand;
    }
}
