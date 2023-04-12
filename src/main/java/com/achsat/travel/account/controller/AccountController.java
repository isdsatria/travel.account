package com.achsat.travel.account.controller;

import com.achsat.travel.account.model.AccountDetail;
import com.achsat.travel.account.service.IAccountDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("account")
public class AccountController {

        @Autowired
        @Qualifier("accountDetailServiceJPA")
        private IAccountDetailService accountDetailService;

        @GetMapping("/id")
        public @ResponseBody AccountDetail getAccountById(@RequestParam("id") int id){
            AccountDetail model = new AccountDetail();
            model.setId(id);
            return accountDetailService.findAccountById(model);
        }


}
