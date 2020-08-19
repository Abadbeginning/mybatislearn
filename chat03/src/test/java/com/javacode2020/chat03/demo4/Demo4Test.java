package com.javacode2020.chat03.demo4;

import com.javacode2020.chat03.demo4.dto.UserFindDto;
import com.javacode2020.chat03.demo4.mapper.UserMapper;
import com.javacode2020.chat03.demo4.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 水面行走
 * @date 2020/8/18 10:36 
 */
@Slf4j
public class Demo4Test {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        //指定mybatis全局配置文件
        String resource = "test3/mybatis-config.xml";
        //读取全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 通过map给Mapper接口的方法传递参数
     */
    @Test
    public void getByName() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getByName("路人甲Java");
            log.info("{}", userModel);
        }
    }

    @Test
    public void getByMaps() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1L);
            map.put("name", "张学友");
            List<UserModel> userModel = userMapper.getByMap(map);
            log.info("{}", userModel);
        }
    }

    @Test
    public void getListByUserFindDto(){
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserFindDto userFindDto = UserFindDto.builder().userId(1L).userName("张学友").build();
            List<UserModel> userModel = userMapper.getListByUserFindDto(userFindDto);
            userModel.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    @Test
    public void getListByIdCollection(){
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> longs = Arrays.asList(1L, 3L);
            List<UserModel> userModel = userMapper.getListByIdCollection(longs);
            userModel.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    @Test
    public void getListByIdList(){
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Long> longs = Arrays.asList(1L, 3L);
            List<UserModel> userModel = userMapper.getListByIdCollection(longs);
            userModel.forEach(item -> {
                log.info("{}", item);
            });
        }
    }

    @Test
    public void getByIdOrName(){
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = userMapper.getByIdOrName(1L, "张学友");
            log.info("{}", userModel);
        }
    }

    @Test
    public void getList(){
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true);) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.getList(context -> {
                //将context参数转换为DefaultResultContext对象
                DefaultResultContext<UserModel> defaultResultContext = (DefaultResultContext<UserModel>) context;
                log.info("{}", defaultResultContext.getResultObject());
                // 遍历到第二条结束
                if (2 == defaultResultContext.getResultCount()){
                    // 结束
                    defaultResultContext.stop();
                }
            });
        }
    }

}