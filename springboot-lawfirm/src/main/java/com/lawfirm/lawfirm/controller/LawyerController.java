package com.lawfirm.lawfirm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lawyer")
public class LawyerController {

    @GetMapping("/dashboard")
    public String lawyerDashboard() {
        return "lawyer_dashboard"; // lawyer_dashboard.html
    }
}
