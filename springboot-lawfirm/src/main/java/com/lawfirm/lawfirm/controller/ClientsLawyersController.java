package com.lawfirm.lawfirm.controllers;

import com.lawfirm.lawfirm.models.Client;
import com.lawfirm.lawfirm.models.Lawyer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientsLawyersController {

    @GetMapping("/clients-lawyers")
    public String showClientsAndLawyersPage(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("lawyer", new Lawyer());
        return "clients_lawyers";
    }

    @PostMapping("/add-client")
    public String addClient(@ModelAttribute Client client) {
        // TODO: Save to DB later, for now just print or log
        System.out.println("Client added: " + client.getName());
        return "redirect:/clients-lawyers";
    }

    @PostMapping("/add-lawyer")
    public String addLawyer(@ModelAttribute Lawyer lawyer) {
        // TODO: Save to DB later, for now just print or log
        System.out.println("Lawyer added: " + lawyer.getName());
        return "redirect:/clients-lawyers";
    }
}
