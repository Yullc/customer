package com.example.customer.repository;

import com.example.customer.vo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserRepository {
    List<Customer> getCustomers(String code, String name, Date birth, String tel, String address, String company);
}
