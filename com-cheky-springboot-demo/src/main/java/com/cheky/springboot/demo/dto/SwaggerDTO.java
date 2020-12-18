package com.cheky.springboot.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author cheky
 * @date 2020-12-18
 *
 * 测试 Swagger的元注解
 * 注意：效果展示请跳转到对应的URL
 */
@lombok.Setter
@lombok.Getter
@lombok.ToString
@ApiModel("使用 @ApiModel")
public class SwaggerDTO {

    @ApiModelProperty("使用 @ApiModelProperty")
    private Integer id;

    @ApiModelProperty(value = "使用 value", example = "使用 example")
    private String email;

    @ApiModelProperty(hidden = true)
    private String remark;
}
