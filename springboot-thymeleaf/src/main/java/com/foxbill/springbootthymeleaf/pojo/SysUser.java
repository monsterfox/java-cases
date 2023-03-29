package com.foxbill.springbootthymeleaf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysUser {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;


}
