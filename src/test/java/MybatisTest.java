import com.gjl.topmovies.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<User> users = sqlSession.selectList("getAllUser");

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
        int succ = sqlSession.insert("insertUser", newUser);
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
        newUser.setUserId(6);
        int succ = sqlSession.update("updateUser", newUser);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void selectOneTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("getUserById", "1");

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

        int userId = 6;
        int succ = sqlSession.delete("deleteUser", "" + userId);

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

        List<User> users = sqlSession.selectList("getUserByName", "张");

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

        Map<String, Object> queryParams = new HashMap();
        queryParams.put("username", "张");
        queryParams.put("email", "sina");

        List<User> users = sqlSession.selectList("getUserByNameAndEmail", queryParams);

        System.out.println("show select users:");
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
