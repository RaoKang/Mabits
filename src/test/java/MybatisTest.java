import com.entity.User;
import com.mapper.UserMapper;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest
{
    @Test
    public void test() throws IOException {
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        for (User u:users) {
            System.out.println(u);
        }
    }
    @Test
    public void test1() throws IOException {
        String resource= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(4,"admin","12314",23,"男","12364@qq.com");

        int i = mapper.insert(user);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public  void update(){
        SqlSessionUtil sqlSessionUtil=new SqlSessionUtil();
        SqlSession sqlSession = sqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int xiaomin = mapper.update("xiaomin", 1);
        System.out.println(xiaomin);
    }
}
