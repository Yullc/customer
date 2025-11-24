package com.example.customer.controller;

import com.example.customer.service.ContractService;
import com.example.customer.vo.Contract;
import com.example.customer.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService service;

    @GetMapping("/customers")
    public List<String> getCustomerNames() {
        return service.getAllCustomerNames();
    }

    @GetMapping("/customerInfo")
    public Customer getCustomerInfo(@RequestParam String name) {
        return service.getCustomerByName(name);
    }

    @GetMapping("/products")
    public List<String> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/admins")
    public List<String> getAdmins() {
        return service.getAllAdmins();
    }

    @GetMapping("/list")
    public List<Contract> getList(@RequestParam String customerCode) {
        return service.getContractsByCustomer(customerCode);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Contract contract) {
        return service.insertContract(contract) > 0;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam String customerCode,
                          @RequestParam String contractName,
                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date regDate) {
        System.out.println("Deleting contract for customerCode: " + customerCode + ", contractName: " + contractName + ", regDate: " + regDate);
        return service.deleteContract(customerCode, contractName, regDate) > 0;
    }
}
