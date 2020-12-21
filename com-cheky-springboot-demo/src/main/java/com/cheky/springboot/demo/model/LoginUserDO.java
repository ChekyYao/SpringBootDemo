package com.cheky.springboot.demo.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author cheky
 * @date 2020-12-21
 */
@Data
public class LoginUserDO {
    private Long id;

    private String name;

    @ToString.Exclude
    private String password;

    private String email;
}
