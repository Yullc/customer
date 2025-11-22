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
public class Admin {
    private Long id;
    private String name;
    private String passwd;
    private String position;
    private String jumin;
    private Date inputDate;
}
