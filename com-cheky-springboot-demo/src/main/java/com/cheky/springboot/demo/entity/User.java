package com.cheky.springboot.demo.entity;

import lombok.Data;

import javax.persistence.*;

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
}
