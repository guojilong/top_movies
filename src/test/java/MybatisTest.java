import com.gjl.topmovies.mapper.UserDao;
import com.gjl.topmovies.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by guojilong on 2017/10/25.
 */
public class MybatisTest {

    @Test
    public void queryTest() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users;
//        users = sqlSession.selectList("getAllUser");

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        users = userDao.getAllUser();

        System.out.println("show all users:");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }


    @Test
    public void insertTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User newUser = new User();
        newUser.setUserName("王五");
        newUser.setUserEmail("");
//        int succ = sqlSession.insert("insertUser", newUser);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int succ = userDao.insertUser(newUser);
        sqlSession.commit();

        System.out.println("insert new user :" + newUser.getUserName() + "  succ: " + (succ == 1));


        queryTest();
        sqlSession.close();

    }

    @Test
    public void updateTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        User newUser = new User();
        newUser.setUserName("王五");
        newUser.setUserEmail("wangwu@qq.com");
        newUser.setUserId(8);
//        int succ = sqlSession.update("updateUser", newUser);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUser(newUser);
        sqlSession.commit();


        sqlSession.close();
    }

    @Test
    public void selectOneTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        User user = sqlSession.selectOne("getUserById", "1");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);

        if (user != null) {
            System.out.println(user);
        }


        sqlSession.close();
    }


    @Test
    public void deleteTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int userId = 8;
//        int succ = sqlSession.delete("deleteUser", "" + userId);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int succ = userDao.deleteUser(userId + "");
        if (succ > 0) {
            System.out.println("delete user where userId=" + userId + "  succ");
        }
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void queryUserByNameTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        List<User> users = sqlSession.selectList("getUserByName", "张");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getUserByName("张");
        System.out.println("show all users:");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void querySinaUserZhang() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

//        Map<String, Object> queryParams = new HashMap();
//        queryParams.put("username", "张");
//        queryParams.put("email", "sina");
//
//        List<User> users = sqlSession.selectList("getUserByNameAndEmail", queryParams);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getUserByNameAndEmail("张", "sina");

        System.out.println("show select users:");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
