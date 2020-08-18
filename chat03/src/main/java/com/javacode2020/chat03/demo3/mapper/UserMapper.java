package com.javacode2020.chat03.demo3.mapper;

import com.javacode2020.chat03.demo3.model.UserModel;

import java.util.List;

/**
 * @author 水面行走
 * @date 2020/8/10 8:44 
 */

public interface UserMapper {
    int insertUser(UserModel userModel);
    int updateUser(UserModel userModel);
    int deleteUser(UserModel userModel);
    List<UserModel> getUserList();
}
