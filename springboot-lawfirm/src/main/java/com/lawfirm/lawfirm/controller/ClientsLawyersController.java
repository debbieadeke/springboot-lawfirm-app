package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.Client;
import com.lawfirm.lawfirm.models.Lawyer;
import com.lawfirm.lawfirm.repository.ClientRepository;
import com.lawfirm.lawfirm.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientsLawyersController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LawyerRepository lawyerRepository;

    @GetMapping("/clients-lawyers")
    public String showClientsAndLawyersPage(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("lawyer", new Lawyer());
        return "clients_lawyers";
    }

    @PostMapping("/add-client")
    public String addClient(@ModelAttribute Client client) {
        clientRepository.save(client); // ✅ Correct usage
        System.out.println("Client added: " + client.getName());
        return "redirect:/clients-lawyers";
    }

    @GetMapping("/clients-report")
    public String viewClientsReport(Model model) {
        model.addAttribute("clients", clientRepository.findAll()); // Fetch all clients
        return "clients_report"; // Must match the file name in templates/
    }

    @PostMapping("/add-lawyer")
    public String addLawyer(@ModelAttribute Lawyer lawyer) {
        lawyerRepository.save(lawyer); // ✅ Correct usage
        System.out.println("Lawyer added: " + lawyer.getName());
        return "redirect:/clients-lawyers";
    }
}
