package com.cheky.springboot.demo.model;

import lombok.Data;
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
@Data
public class EmployeeDO {

    @Id
    private Integer id;

    @Column
    private String Name;
}
