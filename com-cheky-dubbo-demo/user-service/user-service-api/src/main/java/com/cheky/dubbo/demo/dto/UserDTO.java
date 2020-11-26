package com.cheky.dubbo.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * User DTO
 * @author Cheky
 */
@Setter
@Getter
@ToString
public class UserDTO implements Serializable {
    private Integer id;

    private String email;

    private String lastName;
}
