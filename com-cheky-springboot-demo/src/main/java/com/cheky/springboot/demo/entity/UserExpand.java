package com.cheky.springboot.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Cheky
 */
@Entity
@Table(name = "ue_user_expand")
@Setter
@Getter
@ToString
public class UserExpand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "last_login_place")
    private String lastLoginPlace;
}
