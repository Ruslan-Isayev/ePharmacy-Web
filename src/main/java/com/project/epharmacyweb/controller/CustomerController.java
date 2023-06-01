package com.project.epharmacyweb.controller;

import com.project.epharmacyweb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerService.getCustomerList());
        return "customers";
    }
}
