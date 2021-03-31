import cn.bdqn.domain.Account;
import cn.bdqn.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisText {
    @Test
    public void testMyBatis() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = ssf.openSession();

        AccountMapper accountMapper = session.getMapper(AccountMapper.class);
        List<Account> accounts = accountMapper.selectAll();
        System.out.println(accounts);

        is.close();
        session.close();
    }
}
