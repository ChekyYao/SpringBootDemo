package com.cheky.springboot.demo.model;

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
public class UserExpandDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = UserDO.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDO user;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "last_login_place")
    private String lastLoginPlace;
}
