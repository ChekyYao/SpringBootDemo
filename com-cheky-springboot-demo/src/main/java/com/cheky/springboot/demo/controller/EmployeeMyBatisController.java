package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.bean.EmployeeDO;
import com.cheky.springboot.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeMyBatisController {
    @Autowired
    EmployeeMapper employeeMapper;

    //http://localhost:8080/mybatis/emp/3
    @GetMapping("mybatis/emp/{id}")
    public EmployeeDO getEmployee(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }

    //http://localhost:8080/mybatis/emp?id=3&name=Druid
    @GetMapping("mybatis/emp")
    public EmployeeDO insertEmp(EmployeeDO employeeDO){
        employeeMapper.insertEmp((employeeDO));
        return employeeDO;
    }

}
