package com.cheky.springboot.demo.mapper;

import com.cheky.springboot.demo.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Delete("delete employee where id=#{id}")
    public int deleteEmpById(Integer id);

    @Insert("insert into employee(id,name) value(#{id},#{name})")
    public int insertEmp(Employee emp);

    @Update("update employee set name=#{name} where id=#{id}")
    public int updateEmp(Employee emp);
}
