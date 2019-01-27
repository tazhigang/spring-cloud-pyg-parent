package com.ittzg.cloud.repository.brand;

import com.ittzg.cloud.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 15:13
 * @Description:
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand,Long>{
    /**
     *  运营商平台中的品牌管理中的查所有
     * @return 返回所有品牌的列表
     */
    List<Brand> findAll();

    /**
     *  获取当前页的品牌列表
     * @param pageable Jpa原生分页
     * @return
     */
    Page<Brand> findAll(Pageable pageable);
}
