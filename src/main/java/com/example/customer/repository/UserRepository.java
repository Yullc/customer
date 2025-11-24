package com.example.customer.repository;

import com.example.customer.vo.Admin;
import com.example.customer.vo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserRepository {
    List<Customer> getCustomers(String code);

    Admin doLogin(String name, String passwd);

    int register(Customer customer);

    List<Customer> searchCustomersByName(String name);

    int updateCustomer(Customer customer);

    int deleteCustomer(String code);
}
