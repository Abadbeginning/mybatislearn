import com.google.UserMapper;
import com.google.UserModel;
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
 * @date 2020/7/21 10:55 
 */
@Slf4j // 类似private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserTest.class);
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // 指定mybatis全局配置文件
        String resource = "mybatis-config.xml";
        // 读取全局配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 构建sqlsession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        this.sqlSessionFactory = sqlSessionFactory;

    }

    @Test
    public void insertUser(){
        // 自动提交
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        // 非自动提交
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        try {
            //执行业务操作，如：增删改查

            // 创建usermodel对象
            UserModel userModel = UserModel.builder().id(2L).age(123).name("小但是明").salary(123.3).sex(0).build();

            // 插入
            int result = sqlSession.insert("com.google.UserMapper.insertUser", userModel);

            log.info("插入影响行数：{}", result);
            // openSession(true)时 无需手动提交事务
//            sqlSession.commit();

        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void insertUser1(){
        // 自动提交
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        // 非自动提交
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        try {
            //执行业务操作，如：增删改查
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            // 创建usermodel对象
            UserModel userModel = UserModel.builder().id(1L).age(123).name("我的第三方").salary(123.3).sex(0).build();

            // 插入
//            int result = sqlSession.insert("com.google.UserMapper.insertUser", userModel);
            int result = mapper.insertUser(userModel);
            log.info("插入影响行数：{}", result);
            // openSession(true)时 无需手动提交事务
//            sqlSession.commit();

        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void updateUser(){
        // 自动提交
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        // 非自动提交
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        try {
            //执行业务操作，如：增删改查

            // 创建usermodel对象
            UserModel userModel = UserModel.builder().id(1L).age(32).name("被锁定").salary(123.3).sex(0).build();

            // 更新
            int result = sqlSession.update("com.google.UserMapper.updateUser", userModel);

            log.info("插入影响行数：{}", result);
            // openSession(true)时 无需手动提交事务
//            sqlSession.commit();

        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser(){
        // 自动提交
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        // 非自动提交
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        try {
            //执行业务操作，如：增删改查

            // 删除需要的用户id
            long userId = 1L;

            // 删除
            int result = sqlSession.update("com.google.UserMapper.deleteUser", userId);

            log.info("插入影响行数：{}", result);
            // openSession(true)时 无需手动提交事务
//            sqlSession.commit();

        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserList(){
        // 自动提交
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        // 非自动提交
//        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        try {
            //执行业务操作，如：增删改查

            // 删除需要的用户id
            long userId = 1L;

            // 删除
            List<UserModel> lists = sqlSession.selectList("com.google.UserMapper.getUserList");

            log.info("插入影响行数：{}", lists);
            // openSession(true)时 无需手动提交事务
//            sqlSession.commit();

        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }
}
