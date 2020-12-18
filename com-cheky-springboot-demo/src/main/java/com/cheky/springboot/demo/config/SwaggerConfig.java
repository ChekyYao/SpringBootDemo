package com.cheky.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author cheky
 */
@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApiForAll(Environment environment) {

        var profiles = Profiles.of("dev","test");
        var flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("C#转Java学习之路 —— All RESTful APIs"))
                .groupName("所有API")
                .enable(flag) // 当环境为 dev 或 test 时， URL http://localhost:8080/swagger-ui/index.html 才能被访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cheky.springboot.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createRestApiForCaptcha(Environment environment) {

        var profiles = Profiles.of("dev","test");
        var flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("C#转Java学习之路 —— Captcha RESTful APIs"))
                .groupName("验证码")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cheky.springboot.demo.controller.captcha"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(String title) {
        return new ApiInfoBuilder()
                .title(title)
                .contact(new Contact("cheky yao", "", "13925568211@163.com"))
                .build();
    }
}
