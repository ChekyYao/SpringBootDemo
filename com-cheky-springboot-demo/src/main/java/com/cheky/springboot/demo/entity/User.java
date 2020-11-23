package com.cheky.springboot.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheky
 */
@Entity
@Table(name = "ur_user")
@Setter
@Getter
@ToString
//@Data // 使用此注解会导致级联删除时，由于HashCode集合递归而造成内存溢出，从而导致级联删除失败
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

    //mappedBy: 放弃外键维护，关系参照 对方配置关系的属性名
    //cascade: 级联操作
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private UserExpand userExpand;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserAddress> userAddresses = new HashSet<>();

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles = new HashSet<>();
}
