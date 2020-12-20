package com.cheky.springboot.demo.jodd;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.junit.jupiter.api.Test;

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
}
