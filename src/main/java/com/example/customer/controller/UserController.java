package com.example.customer.controller;

import com.example.customer.service.UserSerivce;
import com.example.customer.vo.Admin;
import com.example.customer.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSerivce userService;

    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getCustomers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code
    ) {
        if (name != null && !name.isBlank()) {
            return userService.searchCustomersByName(name);
        }
        return userService.getCustomers(code);
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean doLogin(@RequestBody Admin admin) {
        System.out.println("로그인 진입");
        System.out.println("Received login request for user: " + admin.getName());
        System.out.println("Password: " + admin.getPasswd());
        Admin adminLogin = userService.doLogin(admin.getName(), admin.getPasswd());

        if (adminLogin != null && adminLogin.getName().equals(admin.getName())) {
            return true;
        } else {
            return false;
        }
    }
    @PostMapping("/register")
    @ResponseBody
    public boolean registerUser(@RequestBody Customer customer) {

        if (customer.getName() == null || customer.getBirth() == null || customer.getTel() == null){
            System.out.println("필수항목을 입력 해 주세요.");
            return false;
        }
        int rows = userService.register(customer);

        return rows > 0;
    }

    @PostMapping("/update")
    @ResponseBody
    public boolean updateCustomer(@RequestBody Customer customer) {
        int result = userService.updateCustomer(customer);
        return result > 0;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean deleteCustomer(@RequestParam String code) {
        return userService.deleteCustomer(code) > 0;
    }


}
