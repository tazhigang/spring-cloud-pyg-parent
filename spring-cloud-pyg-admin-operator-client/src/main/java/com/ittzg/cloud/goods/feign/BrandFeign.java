package com.ittzg.cloud.goods.feign;

import com.ittzg.cloud.dto.response.goods.brand.Brand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 18:25
 * @Description:
 */
@Component
@FeignClient(name = "SPRING-CLOUD-PYG-GOODS-SERVICE")
public interface BrandFeign {
    @RequestMapping(value = "/brand/getAllBrand", method = RequestMethod.GET)
    List<Brand> getAll();
    @RequestMapping(value = "/brand/getAllBrandByPage/{pageSize}/{PageNum}", method = RequestMethod.GET)
    Map<String,Object> getBrandsByPage(@PathVariable(value = "pageSize")  Integer pageSize,
                                               @PathVariable(value = "PageNum")  Integer PageNum);
    @RequestMapping(value = "/brand/addOrUpdateBrand",method = RequestMethod.POST)
    Map<Boolean,String> addOrUpdateBrand(@RequestBody Brand brand);
    @RequestMapping(value = "/brand/queryOneById",method = RequestMethod.GET)
    Brand findOne(@RequestParam(value = "id") long id);
}
