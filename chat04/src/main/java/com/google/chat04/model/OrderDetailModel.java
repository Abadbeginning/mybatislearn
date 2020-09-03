package com.google.chat04.model;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/9/3 10:41 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDetailModel {
    private int id;
    private int orderId;
    private int goodsId;
    private int num;
    private Double totalPrice;

}
