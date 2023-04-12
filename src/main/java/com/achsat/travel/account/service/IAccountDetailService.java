package com.achsat.travel.account.service;

import com.achsat.travel.account.model.AccountDetail;

public interface IAccountDetailService {

    void insert(AccountDetail acct);
    void update(AccountDetail acct);

    AccountDetail findAccountByEmail(AccountDetail acct);
    AccountDetail findAccountById(AccountDetail acct);


}
