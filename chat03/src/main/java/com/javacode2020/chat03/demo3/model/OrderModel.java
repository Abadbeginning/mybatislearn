package com.javacode2020.chat03.demo3.model;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/8/12 16:54 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderModel {
    private Long id;
    private Long user_id;
    private Double price;
}