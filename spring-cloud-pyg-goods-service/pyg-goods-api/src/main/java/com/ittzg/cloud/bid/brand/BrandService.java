package com.ittzg.cloud.bid.brand;

import com.ittzg.cloud.model.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

import java.util.List;
/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 15:12
 * @Description:
 */
public interface BrandService {
    /**
     * 获取品牌列表
     * @return
     */
    List<Brand> getAllBrand();

    /**
     * 获取当前页的品牌列表
     * @param pageSize 当前页品牌的记录容量
     * @param PageNum 当前页码
     * @return 当前页品牌列表
     */
    Page<Brand> getBrandsByPage(Integer pageSize, Integer PageNum);
}
