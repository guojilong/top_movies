import com.gjl.topmovies.dto.LoginUser;
import com.gjl.topmovies.mapper.UserDao;
import com.gjl.topmovies.model.Response;
import com.gjl.topmovies.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.faces.render.ResponseStateManager;

/**
 * Created by guojilong on 2017/10/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class SpringTest {
    @Autowired
    LoginServiceImpl loginService;

    @Autowired
    UserDao userDao;

    @Test
    public void iocTest() {

     Response<LoginUser> loginUserResponse= loginService.login("张三", "awaawd");

        System.out.println(loginUserResponse);

//       List<User> users= userDao.getAllUser();
//
//        for (User user : users) {
//            System.out.println(user);
//        }

//        User user=new User();
//        user.setUserName("王五");
//        user.setUserEmail("wangwu@sina.com");
//        userDao.insertUser(user);




    }
}
