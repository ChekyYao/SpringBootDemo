//package com.cheky.springboot.demo.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class DruidConfig {
//
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druid(){
//        return  new DruidDataSource();
//    }
//
//    //1.配置Druid的监控
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        var bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        var initParams = new HashMap<>();
//        initParams.put("loginUsername","admin");
//        initParams.put("loginPassword","123");
//        initParams.put("allow","");
//        bean.setInitParameters(initParams);
//        return bean;
//    }
//
//    //2.配置一个Web监控的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        var bean = new FilterRegistrationBean();
//        bean.setFilter(new WebStatFilter());
//
//        var initParams = new HashMap<>();
//        initParams.put("exclusions","*.js,*.css,/druid/*");
//        initParams.put("profileEnable","true");
//        bean.setInitParameters(initParams);
//
//        bean.setUrlPatterns(Arrays.asList("/*"));
//        return bean;
//    }
//}
