package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.dto.SwaggerDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheky
 * @date 2020-12-18
 *
 * 测试 Swagger的元注解
 * 注意：效果展示请跳转到对应的URL
 * 
 */
@Api(tags = {"hello-swagger-controller", "使用 @Api"})
@RestController
public class HelloSwaggerController {


    @ApiOperation("使用 @ApiOperation")
    // @ResponseHeader(name="使用 @ResponseHeader name",description="使用 @ResponseHeader description") // 在界面没找到它的直观效果
    @GetMapping("/hello/swagger/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "使用@ApiResponse，并且操作成功"),
            @ApiResponse(code = 500, message = "使用@ApiResponse，失败了")})
    public SwaggerDTO helloSwagger(@ApiParam("使用 @ApiParam") @PathVariable("id") final Integer id){
        if(id < 1){
            var temp = 5/0;
        }
        var result = new SwaggerDTO();
        result.setId(id);
        return result;
    }
}
