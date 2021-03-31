package cn.bdqn.controller;

import cn.bdqn.domain.Account;
import cn.bdqn.service.impl.AccountServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountContoller {

    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/queryAll")
    public List<Account> queryAll(){

      List<Account>  accounts= accountService.queryAll();

        return  accounts;

    }

    @RequestMapping(value = "/save")
    public Map<String,Object> save(){

        Account account1=new Account();
        account1.setName("金穗生");
        account1.setAge(2);
        account1.setBalance(200);
        accountService.save(account1);

        Map<String,Object> map= new HashMap<String, Object>();
        map.put("Code",200);
        map.put("Mssage","注册成功");
        map.put("Data",null);
        return  map;
    }

        @RequestMapping(value = "/queryAllByPage")
        public ModelAndView queryAllByPage(@RequestParam(name = "currentPage", required = true, defaultValue = "1")  Integer currentPage){

            PageInfo<Account> pageInfo = accountService.queryAllByPage(currentPage , 10);

            ModelAndView mv=new ModelAndView();
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("list");

            return mv;
        }
    }

