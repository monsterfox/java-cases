package com.ambow.controller;

import com.ambow.pojo.Brand;
import com.ambow.pojo.FormBrand;
import com.ambow.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;


/*    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findByPage")
    public PageInfo<Brand> findByPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize){
        PageInfo<Brand> pageInfo = brandService.pageSearch(pageNum, pageSize);
        return pageInfo;
    }*/

    @PostMapping("/addBrand")
    public boolean addBrand(@RequestBody Brand brand){
        return brandService.addBrand(brand);
    }

    @PostMapping("/modifyBrand")
    public boolean modifyBrand(@RequestBody Brand brand){
        return brandService.modifyBrand(brand);
    }

    @GetMapping("/batchDelete")
    public boolean batchDelete(int[] ids){
        return brandService.removeBrandByBatch(ids);
    }

    @PostMapping("/multiSearchByPage")
    public PageInfo<Brand> multiSearchByPage(@RequestBody FormBrand formBrand){
        System.out.println(formBrand);
        PageInfo<Brand> pageInfo = brandService.pageSearchByCondition(formBrand);
        return pageInfo;
    }



}
