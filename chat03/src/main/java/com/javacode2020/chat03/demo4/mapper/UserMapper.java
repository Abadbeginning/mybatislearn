package com.javacode2020.chat03.demo4.mapper;

import com.javacode2020.chat03.demo4.dto.UserFindDto;
import com.javacode2020.chat03.demo4.model.UserModel;

import java.util.List;
import java.util.Map;

/**
 * @author 水面行走
 * @date 2020/8/18 9:31 
 */

public interface UserMapper {
    // 当只有一个参数时 #{xxx} xxx参数名随意
    UserModel getByName(String name);

    // map传参
    List<UserModel> getByMap(Map<String, Object> maps);

    List<UserModel> getListByUserFindDto(UserFindDto userFindDto);

    UserModel getByIdOrName(Long id, String name);
    UserModel getByIdOrName1(Long id, String name);

}
