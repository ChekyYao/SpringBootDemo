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
@Table(name = "employee")
@Setter
@Getter
@ToString
public class EmployeeDO {

    @Id
    private Integer id;

    @Column
    private String Name;
}
