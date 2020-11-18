package com.cheky.springboot.demo.mapper;

import com.cheky.springboot.demo.bean.EmployeeDO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public EmployeeDO getEmpById(Integer id);

    @Delete("delete employee where id=#{id}")
    public int deleteEmpById(Integer id);

    @Insert("insert into employee(id,name) value(#{id},#{name})")
    public int insertEmp(EmployeeDO emp);

    @Update("update employee set name=#{name} where id=#{id}")
    public int updateEmp(EmployeeDO emp);
}
