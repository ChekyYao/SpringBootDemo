package com.cheky.springboot.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cheky
 */
@Entity
@Table(name = "pr_person_relation")
@Setter
@Getter
@ToString
public class PersonRelationDO extends BaseDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String Name;
}
