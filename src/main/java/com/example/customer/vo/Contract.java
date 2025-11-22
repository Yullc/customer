package com.example.customer.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    private String customerCode;
    private String contractName;
    private int regPrice;
    private Date regDate;
    private int monthPrice;
    private String adminName;
}