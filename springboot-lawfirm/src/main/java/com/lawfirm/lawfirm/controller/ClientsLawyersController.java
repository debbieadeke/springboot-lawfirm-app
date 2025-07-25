package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.Client;
import com.lawfirm.lawfirm.models.Lawyer;
import com.lawfirm.lawfirm.repository.ClientRepository;
import com.lawfirm.lawfirm.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
        System.out.println("Client added: " + client.getFirstName() + " " + client.getLastName());
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
        System.out.println("Lawyer added: " + lawyer.getFirstName() + " " + lawyer.getLastName());
        return "redirect:/clients-lawyers";
    }

    @GetMapping("/lawyers/search")
    public String searchLawyers(@RequestParam("keyword") String keyword, Model model) {
        List<Lawyer> lawyers = lawyerRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrBarNumberContainingIgnoreCase(
                        keyword, keyword, keyword);
        model.addAttribute("lawyers", lawyers);
        return "lawyers_report"; // your HTML template name
    }

    @GetMapping("/lawyers-report")
    public String viewLawyerssReport(Model model) {
        model.addAttribute("lawyers", lawyerRepository.findAll()); // Fetch all clients
        return "lawyers_report"; // Must match the file name in templates/
    }

    // DELETE a lawyer
    @GetMapping("/lawyers/delete/{id}")
    public String deleteLawyer(@PathVariable Long id) {
        lawyerRepository.deleteById(id);
        return "redirect:/lawyers-report";
    }

    // SHOW the edit form
    @GetMapping("/lawyers/edit/{id}")
    public String showEditLawyerForm(@PathVariable Long id, Model model) {
        Lawyer lawyer = lawyerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lawyer Id:" + id));
        model.addAttribute("lawyer", lawyer);
        return "edit_lawyer"; // This is the HTML page you'll create
    }

    // PROCESS the update
    @PostMapping("/lawyers/update/{id}")
    public String updateLawyer(@PathVariable Long id, @ModelAttribute("lawyer") Lawyer updatedLawyer) {
        Lawyer lawyer = lawyerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lawyer Id:" + id));

        // Update fields
        lawyer.setFirstName(updatedLawyer.getFirstName());
        lawyer.setLastName(updatedLawyer.getLastName());
        lawyer.setBarNumber(updatedLawyer.getBarNumber());
        lawyer.setEmail(updatedLawyer.getEmail());
        lawyer.setContact(updatedLawyer.getContact());
        lawyer.setExperience(updatedLawyer.getExperience());
        lawyer.setSpecialization(updatedLawyer.getSpecialization());

        lawyerRepository.save(lawyer);
        return "redirect:/lawyers-report";
    }


     @GetMapping("/clients/search")
    public String searchClientss(@RequestParam("keyword") String keyword, Model model) {
        List<Client> clients = clientRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        keyword, keyword);
        model.addAttribute("clients", clients);
        return "clients_report"; // your HTML template name
    }

    // @GetMapping("/clients-report")
    // public String viewClientsReport(Model model) {
    //     model.addAttribute("clients", clientRepository.findAll()); // Fetch all clients
    //     return "clients_report"; // Must match the file name in templates/
    // }

    // DELETE a lawyer
    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients-report";
    }

    // SHOW the edit form
    @GetMapping("/clients/edit/{id}")
    public String showEditClientForm(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "edit_client"; // This is the HTML page you'll create
    }

    // PROCESS the update
    @PostMapping("/clients/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("client") Client updatedClient) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));

        // Update fields
        client.setFirstName(updatedClient.getFirstName());
        client.setLastName(updatedClient.getLastName());
        client.setEmail(updatedClient.getEmail());
        client.setContact(updatedClient.getContact());
        client.setAddress(updatedClient.getAddress());
        clientRepository.save(client);
        return "redirect:/clients-report";
    }

}

