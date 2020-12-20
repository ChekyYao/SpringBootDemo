package com.cheky.springboot.demo.jodd;

import com.cheky.springboot.demo.bean.EmployeeDO;
import jodd.bean.BeanUtil;
import org.junit.Test;

/**
 * @author Cheky
 * @date 2020-12-20
 *
 * https://www.it610.com/article/1305800703767252992.htm
 */
public class BeanTest {

    @Test
    public void testBeanUtil() {
        var emp = new EmployeeDO();
        BeanUtil.pojo.setProperty(emp, "name", "Cheky"); //设置name属性值为Cheky
        assert BeanUtil.pojo.getProperty(emp, "name") == "Cheky"; //获取name属性值
    }
}
