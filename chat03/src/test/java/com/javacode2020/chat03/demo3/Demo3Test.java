package com.javacode2020.chat03.demo3;

import com.javacode2020.chat03.demo3.mapper.OrderMapper;
import com.javacode2020.chat03.demo3.mapper.UserMapper;
import com.javacode2020.chat03.demo3.model.UserModel;
//import com.javacode2020.chat03.demo3.mapper.UserMapper;
//import com.javacode2020.chat03.demo3.mapper.OrderMapper;
import com.javacode2020.chat03.demo3.model.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 水面行走
 * @date 2020/8/13 13:24 
 */
@Slf4j
public class Demo3Test {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // 指定mybatis全局配置文件
        String resource = "test2/mybatis-config.xml";
        // 读取全局配置文件
        InputStream stream = Resources.getResourceAsStream(resource);
        // 构建对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Test
    public void insertUser() {

    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void test() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 执行查询操作
            List<UserModel> userList = mapper.getUserList();
            userList.forEach(item -> {
                log.info("{}", item);
            });

            log.info("----------------------------------");

             OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            // 执行查询操作
            List<OrderModel> orderList = orderMapper.getList();
            orderList.forEach(item -> {
                log.info("{}", item);
            });

        }
    }

}
