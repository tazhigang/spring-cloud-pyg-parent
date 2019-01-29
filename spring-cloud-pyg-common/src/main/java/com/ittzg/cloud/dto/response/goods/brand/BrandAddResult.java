package com.ittzg.cloud.dto.response.goods.brand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/29 23:09
 * @Description:
 */
@ApiModel
public class BrandAddResult {
    @ApiModelProperty(value = "总记录数",notes ="总记录数" ,example = "22")
    private Boolean success;
    @ApiModelProperty(value = "总记录数",notes ="总记录数" ,example = "22")
    private String responseMsg;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
