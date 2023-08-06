package com.foxbill.domain;

import lombok.Data;

@Data
public class Sale {
    private Integer id;
    private Integer gid;
    private Integer nums;

    public Sale(Integer gid, Integer nums) {
        this.gid = gid;
        this.nums = nums;
    }
}
