package com.ittzg.cloud.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 1:40
 * @Description: 品牌的实体类
 */
@Entity
@Table(name="tb_brand")
@ApiModel
public class Brand {
    @ApiModelProperty(value = "品牌的id",notes = "品牌的id",example = "1")
    private Long id;
    @ApiModelProperty(value = "品牌的名称",notes = "品牌的名称",example = "联想")
    private String name;
    @ApiModelProperty(value = "品牌的名称的首字母",notes = "品牌的名称的首字母",example = "L")
    private String firstChar;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Basic
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    @Column(name="first_char")
    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
