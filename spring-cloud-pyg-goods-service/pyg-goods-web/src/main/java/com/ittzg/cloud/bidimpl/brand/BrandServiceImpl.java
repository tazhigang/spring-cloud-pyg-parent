package com.ittzg.cloud.bidimpl.brand;

import com.ittzg.cloud.bid.brand.BrandService;
import com.ittzg.cloud.model.Brand;
import com.ittzg.cloud.repository.brand.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 17:36
 * @Description:
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    public List<Brand> getAllBrand(){
        return brandRepository.findAll();
    }

    @Override
    public Page<Brand> getBrandsByPage(Integer pageSize, Integer PageNum) {
        PageRequest pageRequest = new PageRequest(PageNum - 1, pageSize);
        Page<Brand>  brandsPage= brandRepository.findAll(pageRequest);
        return brandsPage;
    }
}
