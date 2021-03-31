package cn.bdqn.service.impl;

import cn.bdqn.domain.Account;
import cn.bdqn.mapper.AccountMapper;
import cn.bdqn.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Override
//    @Transactional(readOnly = true ,propagation= Propagation.NOT_SUPPORTED)
    public List<Account> queryAll() {
        List<Account> account=  accountMapper.selectAll();
        return account;
    }

    @Override
//    Transactional
    public void save(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public PageInfo<Account> queryAllByPage(Integer currentPage, Integer pageSize) {

        PageHelper.startPage(currentPage,pageSize);
        List<Account> accounts = accountMapper.selectAll();

        PageInfo<Account> pageInfo = new PageInfo<Account>(accounts);
        return pageInfo;
    }
}
