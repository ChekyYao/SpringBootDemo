package com.cheky.springboot.demo.visualvm;

import com.cheky.springboot.demo.model.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * 使用性能调优工具 visualvm
 *
 * @author Cheky
 * @date 2020-12-10
 */
class JVMTests {

	public static void main(String[] args) throws InterruptedException {
		testMemory();
	}

	public static void testMemory() throws InterruptedException {
		var list = new ArrayList<UserDO>();
		while (true)
		{
			Thread.sleep(10L);
			var user = new UserDO();
			user.setEmail("123123123121212");
			list.add(user);
		}
	}
}
