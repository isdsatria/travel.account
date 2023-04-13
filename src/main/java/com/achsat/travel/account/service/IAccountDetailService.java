package com.achsat.travel.account.service;

import com.achsat.travel.account.model.AccountDetail;
import com.achsat.travel.account.model.dto.AccountDTO;

import java.util.List;

public interface IAccountDetailService {

    void create(AccountDTO acct);
    void update(AccountDTO acct);

    AccountDTO findAccountByEmail(AccountDTO acct);
    AccountDTO findAccountById(AccountDTO acct);

    List<AccountDTO> findAllAccount();


}
