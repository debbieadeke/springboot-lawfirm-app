package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.Appointment;
// import com.lawfirm.lawfirm.models.Client;
// import com.lawfirm.lawfirm.models.Lawyer;
import com.lawfirm.lawfirm.repository.AppointmentRepository;
import com.lawfirm.lawfirm.repository.ClientRepository;
import com.lawfirm.lawfirm.repository.LawyerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LawyerRepository lawyerRepository;

    @GetMapping("/appointments")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("lawyers", lawyerRepository.findAll());
        return "appointments"; // Your form page
    }

    @PostMapping("/add-appointment")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        appointmentRepository.save(appointment);
        System.out.println("Appointment added for client: " + appointment.getClient().getName() +
                " and lawyer: " + appointment.getLawyer().getName());

        return "redirect:/appointments";
    }

    @GetMapping("/appointments-report")
    public String viewAppointmentsReport(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointment_report"; // Your report page
    }
}
