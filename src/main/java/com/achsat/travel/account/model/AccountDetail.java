package com.achsat.travel.account.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="accountdetail")
public class AccountDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="phone_number")
    private Integer phoneNumber;
    @Column(name="email")
    private String email;
}
