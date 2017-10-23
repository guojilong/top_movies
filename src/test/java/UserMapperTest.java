import com.gjl.topmovies.mapping.UserMapper;
import com.gjl.topmovies.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by guojilong on 2017/10/18.
 */


public class UserMapperTest {
    @Autowired
    private UserMapper userDao;

    @Test
    public void insertTest() throws IOException {
        String resource = "spring-mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("哈哈");
        user.setUserEmail("dsfsdfjsdjf@qq.com");

       int value= userDao.insert(user);

        System.out.println("insert data count :"+value);

        sqlSession.commit();

        sqlSession.close();
//        User user = new User();
//        user.setUserName("哈哈");
//        user.setUserEmail("dsfsdfjsdjf@qq.com");
//
//        userDao.insert(user);

    }


    @Test
    public void queryTest() throws IOException {

//        String resource = "spring-mybatis.xml";
//
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
//
//
//        List<User> users = userDao.getAllUser();
//
//        for (User user : users) {
//            System.out.println(user.toString());
//        }
//
//
//        sqlSession.commit();
//
//        sqlSession.close();

        List<User> userLists = userDao.getAllUser();

        for (User user : userLists) {
            System.out.println(user.toString());
        }

    }
}
