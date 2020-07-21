package com.google;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/7/21 20:20 
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
