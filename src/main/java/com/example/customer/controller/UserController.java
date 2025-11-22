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
    public List<Customer> getCustomers(@RequestParam(required = false) String code) {
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
}
