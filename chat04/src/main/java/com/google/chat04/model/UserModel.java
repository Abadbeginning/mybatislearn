package com.google.chat04.model;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/8/29 14:50 
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
    private Integer sex;
}