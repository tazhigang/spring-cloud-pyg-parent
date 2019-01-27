package com.ittzg.cloud.web.brand;


import com.alibaba.fastjson.JSON;
import com.ittzg.cloud.bid.brand.BrandService;
import com.ittzg.cloud.model.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 17:39
 * @Description:
 */
@RestController
@RequestMapping("brand")
@Api(value = "品牌服务接口",tags="Brand-Service",description = "品牌服务接口")
public class BrandController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);
    @Autowired
    private BrandService brandService;
    @GetMapping("getAllBrand")
    @ApiOperation(value = "查询所有的品牌",notes = "查询所有的品牌")
    public List<Brand> getAllBrand(){
        logger.info("url:{},method:{}","/brand/getAllBrand","com.ittzg.cloud.web.brand.BrandController.getAllBrand");
        long begin = System.currentTimeMillis();
        List<Brand> brands = brandService.getAllBrand();
        logger.info("获取品牌列表花费的时间为：{}ms",System.currentTimeMillis()-begin);
        logger.info("response {}", JSON.toJSON(brands).toString());
        return brands;
    }

    @GetMapping("getAllBrandByPage/{pageSize}/{PageNum}")
    @ApiOperation(value = "查询当前页所有的品牌",notes = "查询当前页所有的品牌")
    public Map<String,Object> getAllBrandByPage(@PathVariable(value = "pageSize",required = true)  Integer pageSize,
                                         @PathVariable(value = "PageNum",required = true)  Integer PageNum){
        logger.info("url:/brand/{}/{},method:{}",pageSize,PageNum,"com.ittzg.cloud.web.brand.BrandController.getAllBrandByPage");
        long begin = System.currentTimeMillis();
        Page<Brand> brandsPage = brandService.getBrandsByPage(pageSize, PageNum);
        List<Brand> brands = brandsPage.getContent();
        Integer total = (int)brandsPage.getTotalElements();
        Map<String,Object> map = new HashMap();
        map.put("total",total);
        map.put("brands",brands);

        logger.info("获取该页品牌列表花费的时间为：{}ms",System.currentTimeMillis()-begin);
        logger.info("response {}", JSON.toJSON(brands).toString());
        return map;
    }

}
