import com.gjl.topmovies.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by guojilong on 2017/10/24.
 */
public class SpringTest {
    @Test
    public void iocTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-mybatis.xml");

        User user= (User) context.getBean("user");

        System.out.println("user inject :"+user.getUserName());
    }
}
