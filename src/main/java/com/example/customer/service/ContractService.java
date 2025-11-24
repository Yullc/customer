package com.example.customer.service;

import com.example.customer.repository.ContractRepository;
import com.example.customer.vo.Contract;
import com.example.customer.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository repo;

    public List<String> getAllCustomerNames() {
        return repo.getAllCustomerNames();
    }

    public Customer getCustomerByName(String name) {
        return repo.getCustomerByName(name);
    }

    public List<String> getAllProducts() {
        return repo.getAllProducts();
    }

    public List<String> getAllAdmins() {
        return repo.getAllAdmins();
    }

    public List<Contract> getContractsByCustomer(String customerCode) {
        return repo.getContractsByCustomer(customerCode);
    }

    public int insertContract(Contract c) {
        return repo.insertContract(c);
    }

    public int deleteContract(String customerCode, String contractName, Date regDate) {
        return repo.deleteContract(customerCode, contractName, regDate);
    }
}

