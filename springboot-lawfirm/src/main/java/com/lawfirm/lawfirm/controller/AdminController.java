package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.Lawyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lawfirm.lawfirm.repository.LawyerRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    // ...existing code...
    @Autowired
    private LawyerRepository lawyerRepository;
    // ...existing code...

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin_dashboard"; // admin_dashboard.html
    }

    @GetMapping("/add-lawyer")
    public String showAddLawyerForm(Model model) {
        model.addAttribute("lawyer", new Lawyer());
        return "add_lawyer"; // add_lawyer.html
    }

    // @PostMapping("/add-lawyer")
    // public String addLawyer(@ModelAttribute Lawyer lawyer) {
    // // Save lawyer logic
    // return "redirect:/admin/dashboard";
    // }

    @PostMapping("/save-lawyer")
    public String saveLawyer(@ModelAttribute Lawyer lawyer) {
        lawyerRepository.save(lawyer);
        return "redirect:/admin/dashboard";
    }
}
