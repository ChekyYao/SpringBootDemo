package com.cheky.dubbo.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * User DO
 * @author Cheky
 * @date 2020-11-26
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "ur_user")
public class UserDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String email;

    @Temporal(TemporalType.DATE) //把默认格式 改为 yyyy/MM/dd,即不含时间部分
    @Column(name = "birth_date")
    private Date birthDate;
}
