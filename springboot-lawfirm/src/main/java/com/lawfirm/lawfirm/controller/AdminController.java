package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.Lawyer;
import com.lawfirm.lawfirm.models.Client;
import com.lawfirm.lawfirm.repository.ClientRepository;
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

    @Autowired
    private ClientRepository clientRepository;
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

    @PostMapping("/save-lawyer")
    public String saveLawyer(@ModelAttribute Lawyer lawyer) {
        lawyerRepository.save(lawyer);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/add-client")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add_client"; 
    }

    @PostMapping("/save-client")
    public String saveClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/admin/dashboard";
    }
}
