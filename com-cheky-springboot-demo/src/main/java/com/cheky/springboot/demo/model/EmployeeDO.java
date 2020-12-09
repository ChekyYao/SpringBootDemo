package com.cheky.springboot.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
