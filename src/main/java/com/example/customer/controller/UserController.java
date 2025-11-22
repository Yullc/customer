package com.example.customer.controller;

import com.example.customer.service.UserSerivce;
import com.example.customer.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserSerivce userService;

    @GetMapping("/showList")
    public String showUsers(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth,
            @RequestParam(required = false) String tel,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String company,
            Model model
    ) {

        List<Customer> customers = userService.getCustomers(code, name, birth, tel, address, company);

        model.addAttribute("customers", customers);
        model.addAttribute("code", code);
        model.addAttribute("name", name);
        model.addAttribute("birth", birth);
        model.addAttribute("tel", tel);
        model.addAttribute("address", address);
        model.addAttribute("company", company);

        return "/showList";
    }
}
