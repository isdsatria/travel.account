package com.achsat.travel.account.service;

import com.achsat.travel.account.model.AccountDetail;

import java.util.List;

public interface IAccountDetailService {

    void create(AccountDetail acct);
    void update(AccountDetail acct);

    AccountDetail findAccountByEmail(AccountDetail acct);
    AccountDetail findAccountById(AccountDetail acct);

    List<AccountDetail> findAllAccount();


}
