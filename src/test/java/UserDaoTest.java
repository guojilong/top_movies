import com.gjl.topmovies.mapper.UserDao;
import com.gjl.topmovies.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by guojilong on 2017/10/18.
 */


public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insertTest() throws IOException {
        String resource = "spring-mybatis.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("哈哈");
        user.setUserEmail("dsfsdfjsdjf@qq.com");

       int value= userDao.insertUser(user);

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

        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);


        List<User> users = userDao.getAllUser();

        for (User user : users) {
            System.out.println(user.toString());
        }


        sqlSession.commit();

        sqlSession.close();
//
//        List<User> userLists = userDao.getAllUser();
//
//        for (User user : userLists) {
//            System.out.println(user.toString());
//        }

    }
}
