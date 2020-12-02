package com.cheky.springboot.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author Cheky
 */
@Data
public class UserJacksonDTO {


    private Integer id;

    private String lastName;

    private String email;

    private Date birthDate;

    @JsonIgnore
    private String password;

    private
}
