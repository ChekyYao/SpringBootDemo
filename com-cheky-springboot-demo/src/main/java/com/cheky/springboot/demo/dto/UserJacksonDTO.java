package com.cheky.springboot.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Cheky
 *
 * 元注解
 * Reference: https://www.baeldung.com/jackson-annotations
 * Reference: https://github.com/FasterXML/jackson
 */
@Getter
@Setter
@ToString
public class UserJacksonDTO {

    @JsonProperty("u_id")
    private Integer id;

    private String lastName;

    private String email;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date birthDate;

    @JsonIgnore
    private String password;

    @JsonDeserialize(using = OptimizedBooleanDeserializer.class)
    @JsonSerialize(using = OptimizedBooleanSerializer.class)
    private Boolean enabled;
}
