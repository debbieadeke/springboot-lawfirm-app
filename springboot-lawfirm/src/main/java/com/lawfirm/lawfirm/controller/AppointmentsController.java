package com.lawfirm.lawfirm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentsController {

    @GetMapping("/appointments")
    public String showAppointmentsPage() {
        return "appointments";  // matches appointments.html in templates
    }
}
