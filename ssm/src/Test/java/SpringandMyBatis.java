import cn.bdqn.domain.Account;
import cn.bdqn.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringandMyBatis {
    @Test
    public void testSpring() throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        System.out.println(accountService);
        accountService.queryAll();
    }

    @Test
    public void testSpringAndMyBatis() throws Exception{
        ApplicationContext ac =  new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        List<Account> accounts = accountService.queryAll();

        System.out.println(accounts);
    }

    @Test
    public void testSpringAndMyBatissave() throws Exception{
        ApplicationContext ac =  new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        Account account1=new Account();
        account1.setName("付思鑫");
        account1.setAge(2);
        account1.setBalance(200);
        accountService.save(account1);


    }
}
