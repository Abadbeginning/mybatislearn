package com.javacode2020.chat03.demo2.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author 水面行走
 * @date 2020/8/10 9:57 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Alias("user")
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private Integer sex;
}