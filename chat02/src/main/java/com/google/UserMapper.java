package com.google;

import java.util.List;

/**
 * @author 水面行走
 * @date 2020/7/21 20:38 
 */

public interface UserMapper {
    int insertUser(UserModel userModel);
    int updateUser(UserModel userModel);
    int deleteUser(Long id);
    List<UserModel> getUserList();
}
