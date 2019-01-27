package com.ittzg.cloud.goods.controller;

import com.alibaba.fastjson.JSON;
import com.ittzg.cloud.dto.response.Result;
import com.ittzg.cloud.dto.response.goods.brand.Brand;
import com.ittzg.cloud.dto.response.goods.brand.BrandPageResult;
import com.ittzg.cloud.goods.feign.BrandFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 18:29
 * @Description:
 */
@RestController
@Api(description = "运营商平台中品牌管理")
public class BrandController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
    @Autowired
    private BrandFeign brandFeign;
    @GetMapping(value = "brand/getAll")
    @ApiOperation(value = "获取所有品牌列表",notes = "获取所有品牌列表")
    public Result<List<Brand>> getBrands(){
        Result<List<Brand>> result = new Result<>();
        logger.info("url :{},method:{}","/brand/getAll","getBrands");
        Long begin = System.currentTimeMillis();
        List<Brand> brands = brandFeign.getAll();
        logger.info("response :{}", JSON.toJSON(brands).toString());
        result.setStatusCode("200");
        result.setResultData(brands);
        result.setResponseMSg("获取数据成功");
        logger.info("调用服务获取品牌列表花费的时间为：{}ms",System.currentTimeMillis()-begin);
        return result;
    }

    @GetMapping(value = "brand/getBrandPageResult/{page}/{rows}")
    @ApiOperation(value = "获取当前页所有品牌列表",notes = "获取当前页所有品牌列表")
    public Result<BrandPageResult> getBrandPageResult(@PathVariable(value = "rows",required = true)  Integer rows,
                                             @PathVariable(value = "page",required = true)  Integer page){
        Result<BrandPageResult> result = new Result<>();
        BrandPageResult brandPageResult = new BrandPageResult();
        logger.info("url:/brand/{}/{},method:{}",rows,page,"com.ittzg.cloud.goods.controller.BrandController.getBrandPageResult");
        Long begin = System.currentTimeMillis();
        Map<String, Object> brandsByPage = brandFeign.getBrandsByPage(rows, page);
        logger.info("response :{}", JSON.toJSON(brandsByPage).toString());
        Integer total = null;
        List<Brand> brands = null;
        try {
            total = (Integer) brandsByPage.get("total");
            brands = (List<Brand>) brandsByPage.get("brands");
        } catch (Exception e) {
            result.setStatusCode("500");
            result.setResultData(null);
            result.setResponseMSg("数据格式转化错误");
        }
        brandPageResult.setRows(brands);
        brandPageResult.setTotal(total);
        result.setStatusCode("200");
        result.setResultData(brandPageResult);
        result.setResponseMSg("获取数据成功");
        logger.info("调用服务获取品牌列表花费的时间为：{}ms",System.currentTimeMillis()-begin);
        logger.info("response :{}", JSON.toJSON(brands).toString());
        return result;
    }
}
