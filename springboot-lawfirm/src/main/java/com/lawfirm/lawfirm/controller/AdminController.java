package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.Lawyer;
import com.lawfirm.lawfirm.models.Client;
import com.lawfirm.lawfirm.models.LegalCase;
import com.lawfirm.lawfirm.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lawfirm.lawfirm.repository.LawyerRepository;
import com.lawfirm.lawfirm.repository.CaseRepository;
import com.lawfirm.lawfirm.models.Hearing;
import com.lawfirm.lawfirm.repository.HearingRepository;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CaseRepository caseRepository; // Assuming you have a CaseRepository for managing cases

    @Autowired
    private HearingRepository hearingRepository;

    // @GetMapping("/dashboard")
    // public String adminDashboard() {
    // return "admin_dashboard"; // admin_dashboard.html
    // }

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

    @GetMapping("/add-case")
    public String showAddCaseForm(Model model) {
        model.addAttribute("case", new LegalCase());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("lawyers", lawyerRepository.findAll());
        return "add_case";
    }

    @PostMapping("/save-case")
    public String saveCase(@ModelAttribute LegalCase legalcase) {
        caseRepository.save(legalcase);

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/add-hearing")
    public String showAddHearingForm(Model model) {
        model.addAttribute("hearing", new Hearing());
        model.addAttribute("cases", caseRepository.findAll()); // <-- Add this back
        return "add_hearing";
    }

    @PostMapping("/save-hearing")
    public String saveHearing(@ModelAttribute Hearing hearing,
            @RequestParam("hearingCase") Long caseId) {
        LegalCase selectedCase = caseRepository.findById(caseId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid case ID"));

        hearing.setLegalCase(selectedCase);
        hearingRepository.save(hearing);

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
public String dashboard(Model model, Authentication authentication) {
    // Fetch stats
    long totalClients = clientRepository.count();
    long totalLawyers = lawyerRepository.count();
    long activeCases = caseRepository.countByStatus("open");
    long closedCases = caseRepository.countByStatus("closed");

    // Add stats to model
    model.addAttribute("totalClients", totalClients);
    model.addAttribute("totalLawyers", totalLawyers);
    model.addAttribute("activeCases", activeCases);
    model.addAttribute("closedCases", closedCases);

    // Add user role
    model.addAttribute("role", authentication.getAuthorities().iterator().next().getAuthority());

    return "admin_dashboard";  // same view for admin/lawyer
}

    

}
