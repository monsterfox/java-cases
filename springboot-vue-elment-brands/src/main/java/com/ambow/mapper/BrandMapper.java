package com.ambow.mapper;

import com.ambow.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand (brand_name,company_name,ordered,description,status) values(#{brandName},#{companyName},#{ordered},#{description},#{status})")
    int insertBrand(Brand brand);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    int updateBrand(Brand brand);

    @Delete("delete from tb_brand where id = #{id}")
    int deleteBrandById(int id);

    @Delete("<script>" +
            "    delete from tb_brand where id in\n" +
            "    <foreach collection='list' open='(' close=')' separator=',' item='id'>\n" +
            "        #{id}\n" +
            "    </foreach>" +
            "</script>")
    int deleteByBatch(@Param("list") int[] ids);

/*    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")*/
    List<Brand> multiselect(Brand brand);

}