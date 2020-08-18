package com.javacode2020.chat03.demo4.model;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/8/18 9:30 
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
