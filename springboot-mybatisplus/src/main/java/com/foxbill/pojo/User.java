package com.foxbill.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
//    @Builder.Default
//    private String name = "洛克菲勒";
    private String name;
    private Integer age;
    private double balance;
    @Version
    private Integer version;

    public User(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }
}
