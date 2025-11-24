package com.example.customer.service;

import com.example.customer.repository.UserRepository;
import com.example.customer.vo.Admin;
import com.example.customer.vo.Customer;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSerivce {

    @Autowired
    private UserRepository userRepository;


    public List<Customer> getCustomers(String code) {
        return userRepository.getCustomers(code);
    }

    public Admin doLogin(String name, String passwd) {
        return userRepository.doLogin(name, passwd);
    }

    public int register(Customer customer) {
        return userRepository.register(customer);
    }

    public List<Customer> searchCustomersByName(String name) {
        return userRepository.searchCustomersByName(name);
    }

    public int updateCustomer(Customer customer) {
        return userRepository.updateCustomer(customer);
    }

    public int deleteCustomer(String code) {
        return userRepository.deleteCustomer(code);
    }
}
