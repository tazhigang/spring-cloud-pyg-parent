package com.ittzg.cloud.dto.response.goods.brand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 20:46
 * @Description: 品牌分页结果类
 */
@ApiModel
public class BrandPageResult {
    @ApiModelProperty(value = "总记录数",notes ="总记录数" ,example = "22")
    private Integer total;
    @ApiModelProperty(value = "当前页记录",notes = "当前页记录")
    private List<Brand> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Brand> getRows() {
        return rows;
    }

    public void setRows(List<Brand> rows) {
        this.rows = rows;
    }
}
