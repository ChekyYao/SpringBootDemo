package com.cheky.springboot.demo;

import com.cheky.springboot.demo.controller.security.JwtAuthenticationTokenFilter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@EnableScheduling
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	// 使用监控模板 4701, http://localhost:3000/
	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(){
		return (registry) -> registry.config().commonTags("application","prom-actuator");
	}

	//根据SpringBoot官方让重复执行的filter实现一次执行过程的解决方案，参见官网地址：https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-disable-registration-of-a-servlet-or-filter
	@Bean
	public FilterRegistrationBean registration(JwtAuthenticationTokenFilter filter) {
		FilterRegistrationBean registration = new FilterRegistrationBean(filter);
		registration.setEnabled(false);
		return registration;
	}
}
