import cn.bdqn.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringText {

    @Test
    public void testSpring() throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        System.out.println(accountService);
        accountService.queryAll();
    }
}
