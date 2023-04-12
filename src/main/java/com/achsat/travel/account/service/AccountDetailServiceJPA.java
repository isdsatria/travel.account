package com.achsat.travel.account.service;

import com.achsat.travel.account.model.AccountDetail;
import com.achsat.travel.account.repository.AccountDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailServiceJPA implements IAccountDetailService{

    @Autowired
    AccountDetailRepository repository;
    @Override
    public void insert(AccountDetail acct) {
        repository.save(acct);
    }

    @Override
    public void update(AccountDetail acct) {
        repository.save(acct);
    }

    @Override
    public AccountDetail findAccountByEmail(AccountDetail acct) {
        return repository.findAccountDetailByEmail(acct.getEmail());
    }

    @Override
    public AccountDetail findAccountById(AccountDetail acct) {
        return repository.findAccountDetailById(acct.getId());
    }
}
