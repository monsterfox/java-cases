package com.ambow.service.impl;

import com.ambow.mapper.BrandMapper;
import com.ambow.pojo.Brand;
import com.ambow.pojo.FormBrand;
import com.ambow.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageInfo<Brand> pageSearch(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Brand> list = brandMapper.selectAll();
        PageInfo<Brand> pageInfo = new PageInfo<>(list,7);
        return pageInfo;
    }

    @Override
    public PageInfo<Brand> pageSearchByCondition(FormBrand formBrand) {
        PageHelper.startPage(formBrand.getPageNum(),formBrand.getPageSize());
        List<Brand> list = brandMapper.multiselect(formBrand.getBrand());
        PageInfo<Brand> pageInfo = new PageInfo<>(list,7);
        return pageInfo;
    }

    @Override
    public boolean addBrand(Brand brand) {
        return (brandMapper.insertBrand(brand) == 1)?true:false;
    }

    @Override
    public boolean modifyBrand(Brand brand) {
        return (brandMapper.updateBrand(brand) == 1)?true:false;
    }

    @Override
    public boolean removeBrandById(int id) {
        return (brandMapper.deleteBrandById(id) == 1)?true:false;
    }

    @Override
    public boolean removeBrandByBatch(int[] ids) {
        return (brandMapper.deleteByBatch(ids) != 0)?true:false;
    }



}
