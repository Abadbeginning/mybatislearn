package com.google.chat04.model;

import lombok.*;

import java.util.List;

/**
 * @author 水面行走
 * @date 2020/9/3 8:36 
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private Integer id;
    private Integer userId;
    private Long createTime;
    private Long upTime;

    // 用户下单信息
    private UserModel userModel;

    //订单详情列表
    private List<OrderDetailModel> orderDetailModelList;
}