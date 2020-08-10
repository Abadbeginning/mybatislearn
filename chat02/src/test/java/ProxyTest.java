import com.google.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author 水面行走
 * @date 2020/7/22 10:50 
 */
@Slf4j
public class ProxyTest {
    public static class UserMapperProxy implements InvocationHandler{

        private SqlSession sqlSession;

        private Class<?> mapperClass;

        public UserMapperProxy(SqlSession sqlSession, Class<?> mapperClass){
            this.sqlSession = sqlSession;
            this.mapperClass = mapperClass;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.debug("invoke start");

            String statement = mapperClass.getName() + "." + method.getName();
//            log.debug("statement: {}", statement);
            List<Object> result = sqlSession.selectList(statement);
            log.debug("invoke end");
            return result;
        }

    }

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
    public void test1(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true);){
            //
            UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{UserMapper.class}, new UserMapperProxy(sqlSession, UserMapper.class));
            log.info("{}", userMapper.getUserList());
        }
    }
}
