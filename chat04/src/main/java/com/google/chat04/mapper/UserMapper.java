package com.google.chat04.mapper;

import com.google.chat04.model.UserModel;

/**
 * @author 水面行走
 * @date 2020/8/29 14:55 
 */
public interface UserMapper {

    /**
     * 插入用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    int insertUser(UserModel model);

    /**
     * 更新用户信息，返回影响行数
     *
     * @param model
     * @return
     */
    long updateUser(UserModel model);

    /**
     * 根据用户id删除用户信息，返回删除是否成功
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);

    int insertUser1(UserModel userModel);

    int insertUser2(UserModel userModel);

    int insertUser3(UserModel userModel);

}
