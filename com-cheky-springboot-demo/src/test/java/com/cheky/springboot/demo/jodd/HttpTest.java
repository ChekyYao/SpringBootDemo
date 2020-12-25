package com.cheky.springboot.demo.jodd;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.net.HttpMethod;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

/**
 * @author Cheky
 * @date 2020-12-20
 *
 * https://http.jodd.org/using-the-client
 */
public class HttpTest {

    /**
     * 测试步骤
     * 1. 运行本项目的网站
     * 2. 执行该单元测试
     */
    @Test
    public void testHttp(){
        HttpResponse response = HttpRequest
                .get("http://localhost:8080/jackson/users/1")
                .send();
        var result = response.bodyText();
        System.out.println(result);
    }

    @Test
    public void testHttpPost(){
        String url = "http://localhost:8080/jackson/users/";
        String jsonString = "{\"lastName\":\"Cheky\",\"email\":\"139@163.com\",\"birthDate\":\"25-12-2020 06:52:51\",\"enabled\":1,\"u_id\":100}";
        HttpRequest httpRequest = new HttpRequest().method(HttpMethod.POST).set(url).contentTypeJson().bodyText(jsonString,"application/json");
        var result = httpRequest.send().statusCode();
        assert result == HttpStatus.CREATED.value();
    }
}
