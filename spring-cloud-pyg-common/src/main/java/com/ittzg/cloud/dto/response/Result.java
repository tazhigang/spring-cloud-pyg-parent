package com.ittzg.cloud.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 14:48
 * @Description:
 */
@ApiModel
public class Result<T> {
    @ApiModelProperty(value = "响应结果的状态码",notes = "",example = "200")
    private String statusCode;
    @ApiModelProperty
    private T resultData;
    @ApiModelProperty(value = "响应结果的状态码描述",notes = "响应结果的状态码描述",example = "成功")
    private String responseMSg;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public String getResponseMSg() {
        return responseMSg;
    }

    public void setResponseMSg(String responseMSg) {
        this.responseMSg = responseMSg;
    }
}