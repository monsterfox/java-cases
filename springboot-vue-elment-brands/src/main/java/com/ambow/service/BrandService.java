package com.ambow.service;

import com.ambow.pojo.Brand;
import com.ambow.pojo.FormBrand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    List<Brand> findAll();

    PageInfo<Brand> pageSearch(int pageNum, int pageSize);

    PageInfo<Brand> pageSearchByCondition(FormBrand formBrand);

    boolean addBrand(Brand brand);

    boolean modifyBrand(Brand brand);

    boolean removeBrandById(int id);

    boolean removeBrandByBatch(int[] ids);


}
