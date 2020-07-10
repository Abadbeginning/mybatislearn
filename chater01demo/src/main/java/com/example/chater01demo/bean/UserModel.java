package com.example.chater01demo.bean;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/4/29 8:06
 */
@Data
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
