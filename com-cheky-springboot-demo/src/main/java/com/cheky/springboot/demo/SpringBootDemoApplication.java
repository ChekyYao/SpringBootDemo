package com.cheky.springboot.demo;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	// 使用监控模板 4701, http://localhost:3000/
	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(){
		return (registry) -> registry.config().commonTags("application","prom-actuator");
	}
}
