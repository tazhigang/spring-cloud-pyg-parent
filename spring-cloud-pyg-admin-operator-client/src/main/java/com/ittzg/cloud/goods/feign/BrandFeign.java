package com.ittzg.cloud.goods.feign;

import com.ittzg.cloud.dto.response.goods.brand.Brand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public List<Brand> getAll();
    @RequestMapping(value = "/brand/getAllBrandByPage/{pageSize}/{PageNum}", method = RequestMethod.GET)
    public Map<String,Object> getBrandsByPage(@PathVariable(value = "pageSize")  Integer pageSize,
                                               @PathVariable(value = "PageNum")  Integer PageNum);
}
