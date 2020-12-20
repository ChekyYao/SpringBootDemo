package com.cheky.springboot.demo.jodd;

import com.cheky.springboot.demo.model.EmployeeDO;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import org.junit.Test;

/**
 * @author Cheky
 * @date 2020-12-20
 *
 * https://json.jodd.org/
 */
public class JsonTest {

    @Test
    public void testJson(){
        var emp = new EmployeeDO();
        emp.setId(10);
        emp.setName("Cheky");
        String json = JsonSerializer.create()
                .include("id")
                .serialize(emp);

        var emp2 = new JsonParser()
                .parse(json, EmployeeDO.class);

        assert emp.equals(emp2);
    }
}
