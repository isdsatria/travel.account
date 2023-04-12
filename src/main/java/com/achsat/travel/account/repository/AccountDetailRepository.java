package com.achsat.travel.account.repository;

import com.achsat.travel.account.model.AccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDetailRepository extends JpaRepository<AccountDetail , Integer> {
    AccountDetail findAccountDetailById(Integer id);
    AccountDetail findAccountDetailByEmail(String email);
    List<AccountDetail> findAllByOrderByName();
}
