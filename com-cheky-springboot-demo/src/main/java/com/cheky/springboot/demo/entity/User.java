package com.cheky.springboot.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ur_user")
@Data
public class User {

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

    @Transient // 数据库不生成此列 EmailWithName
    public String getEmailWithName(){
        return lastName + ":" + email;
    }
}
