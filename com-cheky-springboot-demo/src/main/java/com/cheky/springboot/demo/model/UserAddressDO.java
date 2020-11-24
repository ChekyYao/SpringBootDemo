package com.cheky.springboot.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Cheky
 */
@Entity
@Table(name = "ua_user_address")
@Setter
@Getter
@ToString
public class UserAddressDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = UserDO.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDO user;

    @Column
    private String address;
}
