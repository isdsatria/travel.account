package com.achsat.travel.account.model.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Integer id;
    private String name;
    private String address;
    private Integer phoneNumber;
    private String email;
}