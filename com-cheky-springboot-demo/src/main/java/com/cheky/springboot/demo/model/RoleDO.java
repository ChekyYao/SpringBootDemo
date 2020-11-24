package com.cheky.springboot.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheky
 */
@Entity
@Table(name = "ro_role")
@Setter
@Getter
@ToString
public class RoleDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private Set<UserDO> users = new HashSet<>();

    @Column(name = "role_name")
    private String roleName;
}
