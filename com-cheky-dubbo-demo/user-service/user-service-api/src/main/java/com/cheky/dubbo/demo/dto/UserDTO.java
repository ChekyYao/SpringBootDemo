package com.cheky.dubbo.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User DTO
 * @author Cheky
 */
@Setter
@Getter
@ToString
public class UserDTO {
    private Integer id;

    private String email;

    private String lastName;
}
