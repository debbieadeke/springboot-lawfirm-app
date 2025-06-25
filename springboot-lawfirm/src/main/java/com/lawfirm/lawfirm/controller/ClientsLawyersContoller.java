package com.lawfirm.lawfirm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientsLawyersController {

    @GetMapping("/clients-lawyers")
    public String showClientsAndLawyersPage() {
        return "clients_lawyers";  // matches clients_lawyers.html in templates
    }
}
