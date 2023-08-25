package com.ambow;

import com.ambow.mapper.BrandMapper;
import com.ambow.pojo.Brand;
import com.ambow.pojo.FormBrand;
import com.ambow.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootVueElmentBrandsApplicationTests {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandService brandService;

    @Test
    void testMapper(){
        Brand brand = new Brand();
//        brand.setId(49);
//        brand.setBrandName("华为");
        brand.setCompanyName("华为技术有限公司");
//        brand.setOrdered(200);
//        brand.setDescription("康师傅1");
        brand.setStatus(1);

//        int row = brandMapper.insertBrand(brand);
//        int row = brandMapper.updateBrand(brand);
//        int row = brandMapper.deleteBrandById(49);

//        int[] ids = {51,63};
//        int row = brandMapper.deleteByBatch(ids);
//        System.out.println(row);

        List<Brand> list = brandMapper.multiselect(brand);
        list.forEach(b -> System.out.println(b));

    }

    @Test
    void testService(){
        Brand brand = new Brand();
//        brand.setId(50);
//        brand.setBrandName("康师傅1");
//        brand.setCompanyName("华为");
//        brand.setOrdered(200);
//        brand.setDescription("康师傅1");
        brand.setStatus(0);
//        boolean flag = brandService.addBrand(brand);
//        boolean flag = brandService.modifyBrand(brand);
//        boolean flag = brandService.removeBrandById(50);
//        System.out.println(flag);
        FormBrand formBrand = new FormBrand();
        formBrand.setBrand(brand);
        formBrand.setPageNum(1);
        formBrand.setPageSize(5);
        PageInfo<Brand> pageInfo = brandService.pageSearchByCondition(formBrand);
        pageInfo.getList().forEach(brand1 -> System.out.println(brand1));

    }

    @Test
    void testFindAll() {
        List<Brand> list = brandService.findAll();
        list.forEach(brand -> {
            System.out.println(brand);
        });
    }





}
