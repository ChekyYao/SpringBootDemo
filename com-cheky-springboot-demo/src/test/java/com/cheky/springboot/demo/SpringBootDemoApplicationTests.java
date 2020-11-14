package com.cheky.springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringBootDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DataSource dataSource;

	@Test
	void testConnectionForJDBC() throws SQLException {
		System.out.println(dataSource.getClass());
		var conn = dataSource.getConnection();
		System.out.println(conn);
	}

}
