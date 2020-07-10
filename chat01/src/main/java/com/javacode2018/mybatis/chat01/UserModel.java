package com.javacode2018.mybatis.chat01;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/7/9 20:31 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
}