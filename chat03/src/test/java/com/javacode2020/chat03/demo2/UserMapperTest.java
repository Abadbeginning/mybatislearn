package com.javacode2020.chat03.demo2;

import com.javacode2020.chat03.demo2.mapper.UserMapper;
import com.javacode2020.chat03.demo2.UserModel;
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
 * @date 2020/8/10 8:52 
 */
@Slf4j
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // 指定mybatis全局配置文件
        String resource = "test1/mybatis-config.xml";
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
    public void getUserList() {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 执行查询操作
            List<UserModel> userList = mapper.getUserList();
            userList.forEach(item -> {
                log.info("{}", item);
            });
        }
    }
}