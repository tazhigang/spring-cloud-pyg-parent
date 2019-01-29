package com.ittzg.cloud.bidimpl.brand;

import com.ittzg.cloud.bid.brand.BrandService;
import com.ittzg.cloud.model.Brand;
import com.ittzg.cloud.repository.brand.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 17:36
 * @Description:
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Transactional(propagation= Propagation.SUPPORTS,readOnly = true)
    public List<Brand> getAllBrand(){
        return brandRepository.findAll();
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS,readOnly = true)
    public Page<Brand> getBrandsByPage(Integer pageSize, Integer PageNum) {
        PageRequest pageRequest = new PageRequest(PageNum - 1, pageSize);
        Page<Brand>  brandsPage= brandRepository.findAll(pageRequest);
        return brandsPage;
    }

    @Override
    public Map<Boolean,String> addBrand(Brand brand) {
        Map<Boolean, String> map = new HashMap<>();
        try {
            brandRepository.saveAndFlush(brand);
            map.put(true,"成功");
        } catch (Exception e) {
            map.put(false,"失败");
        }
        return map;
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS,readOnly = true)
    public Brand findOneById(Long id) {
        return brandRepository.getOne(id);
    }
}
