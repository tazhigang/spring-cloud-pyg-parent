package com.ittzg.cloud.dto.response.goods.brand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 1:40
 * @Description: 品牌的响应
 */
@ApiModel
public class Brand {
    @ApiModelProperty(value = "品牌的id",notes = "品牌的id",example = "1")
    private Long id;
    @ApiModelProperty(value = "品牌的名称",notes = "品牌的名称",example = "联想")
    private String name;
    @ApiModelProperty(value = "品牌的名称的首字母",notes = "品牌的名称的首字母",example = "L")
    private String firstChar;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
