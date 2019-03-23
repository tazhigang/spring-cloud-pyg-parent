package com.ittzg.cloud.goods.controller;

import com.alibaba.fastjson.JSON;
import com.ittzg.cloud.dto.response.Result;
import com.ittzg.cloud.dto.response.goods.brand.Brand;
import com.ittzg.cloud.dto.response.goods.brand.BrandAddResult;
import com.ittzg.cloud.dto.response.goods.brand.BrandPageResult;
import com.ittzg.cloud.goods.feign.BrandFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    @PostMapping(value = "brand/addOrUpdateBrand")
    @ApiOperation(value = "新增或修改品牌",notes = "新增或修改品牌")
    public Result<BrandAddResult> addOrUpdateBrand(@RequestBody Brand brand){
        Result<BrandAddResult> result = new Result<>();
        BrandAddResult brandAddResult = new BrandAddResult();
        logger.info("url:/brand/addBrand,method:{}","com.ittzg.cloud.goods.controller.BrandController.addBrand");
        long begin = System.currentTimeMillis();
        Map<Boolean, String> map = null;
        try {
            map = brandFeign.addOrUpdateBrand(brand);
        } catch (Exception e) {
            result.setResultData(null);
            result.setStatusCode("405");
            result.setResponseMSg("调用服务失败");
            return result;
        }
        logger.info("调用服务添加品牌花费的时间为：{}ms",System.currentTimeMillis()-begin);
        logger.info("response {}", map.toString());
        for (Boolean success : map.keySet()) {
            brandAddResult.setResponseMsg(map.get(success));
            brandAddResult.setSuccess(success);
            break;
        }
        result.setResultData(brandAddResult);
        result.setStatusCode("200");
        result.setResponseMSg("调用服务成功");
        return result;
    }
    @GetMapping(value = "brand/findById")
    @ApiOperation(value = "根据Id查找品牌详情",notes = "根据Id查找品牌详情")
    public Result<Brand> findById(long id){
        Result<Brand> result = new Result<>();
        logger.info("url:/brand/findById,method:{}","com.ittzg.cloud.goods.controller.BrandController.findById");
        long begin = System.currentTimeMillis();
        Brand brand =null;
        try {
            brand = brandFeign.findOne(id);
        } catch (Exception e) {
            logger.info("{}",e.getMessage());
            result.setResultData(null);
            result.setStatusCode("405");
            result.setResponseMSg("调用服务失败");
            return result;
        }
        logger.info("调用服务根据Id查找品牌详情花费的时间为：{}ms",System.currentTimeMillis()-begin);
        logger.info("response {}", JSON.toJSON(brand).toString());
        result.setResultData(brand);
        result.setStatusCode("200");
        result.setResponseMSg("调用服务成功");
        return result;
    }
    @DeleteMapping(value = "/brand/removeBrandByIds")
    @ApiOperation(value = "批量删除品牌名称",notes = "批量删除品牌名称")
    public Result<BrandAddResult> removeBrandByIds(Long[] ids){
        Result<BrandAddResult> result = new Result<>();
        BrandAddResult brandAddResult = new BrandAddResult();
        logger.info("url:/brand/removeBrandByIds,method:{},param:{}","com.ittzg.cloud.goods.controller.BrandController.removeBrandByIds",ids);
        long begin = System.currentTimeMillis();
        Brand brand =null;
        Map<Boolean, String> booleanStringMap = null;
        try {
            booleanStringMap = brandFeign.removeBrandByIds(ids);
        } catch (Exception e) {
            logger.info("{}",e.getMessage());
            result.setStatusCode("405");
            result.setResponseMSg("调用服务失败");
            return result;
        }
        logger.info("调用服务根据批量删除品牌名称花费的时间为：{}ms",System.currentTimeMillis()-begin);
        logger.info("response {}", JSON.toJSON(booleanStringMap).toString());
        for (Boolean success : booleanStringMap.keySet()) {
            brandAddResult.setResponseMsg(booleanStringMap.get(success));
            brandAddResult.setSuccess(success);
            break;
        }
        result.setResultData(brandAddResult);
        result.setStatusCode("200");
        result.setResponseMSg("调用服务成功");
        return result;
    }
}
