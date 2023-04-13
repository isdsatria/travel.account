package com.achsat.travel.account.service;

import com.achsat.travel.account.model.AccountDetail;
import com.achsat.travel.account.model.dto.AccountDTO;
import com.achsat.travel.account.repository.AccountDetailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountDetailServiceJPA implements IAccountDetailService{

    @Autowired
    AccountDetailRepository repository;
    @Override
    public void create(AccountDTO acct) {

        AccountDetail model = new AccountDetail();
        BeanUtils.copyProperties(acct,model);

        repository.save(model);
    }

    @Override
    public void update(AccountDTO acct) {

        AccountDetail model = new AccountDetail();
        BeanUtils.copyProperties(acct,model);

        repository.save(model);
    }

    @Override
    public AccountDTO findAccountByEmail(AccountDTO acct) {
        AccountDetail model = repository.findAccountDetailByEmail(acct.getEmail());
        AccountDTO dto = new AccountDTO();
        BeanUtils.copyProperties(model,dto);
        return dto;
    }

    @Override
    public AccountDTO findAccountById(AccountDTO acct) {
        AccountDetail model =  repository.findAccountDetailById(acct.getId());
        AccountDTO dto = new AccountDTO();
        BeanUtils.copyProperties(model,dto);
        return dto;
    }

    @Override
    public List<AccountDTO> findAllAccount(){
        List<AccountDetail> modelList= repository.findAllByOrderByName();
        List<AccountDTO> dtoList = new ArrayList<>();
        for(AccountDetail a : modelList){
            AccountDTO dto = new AccountDTO();
            BeanUtils.copyProperties(a,dto);
            dtoList.add(dto);
        }

        return dtoList;
    }

}
