package com.google.chat04.mapper;

import com.google.chat04.model.OrderDetailModel;

/**
 * @author 水面行走
 * @date 2020/9/3 8:46 
 */

public interface OrderDetailMapper {
    OrderDetailModel getListByOrderId(int id);
}
