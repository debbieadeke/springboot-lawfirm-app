package com.lawfirm.lawfirm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.lawfirm.lawfirm.models.Appointment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AppointmentController {

    @GetMapping("/appointments")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointments"; // this should match your appointments.html file name
    }

    @PostMapping("/add-appointment")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        // TODO: Save to DB
        System.out.println("Appointment added: Client ID " + appointment.getClientId() +
                ", Lawyer ID " + appointment.getLawyerId());

        return "redirect:/appointments"; // redirect to the form page again
    }

    @GetMapping("/appointments-report")
    public String viewReport() {
        // TODO: Display appointment report
        return "appointments_report"; // you can create this page later
    }
}

