package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.LegalCase;
import com.lawfirm.lawfirm.models.Hearing;
import com.lawfirm.lawfirm.repository.CaseRepository;
import com.lawfirm.lawfirm.repository.HearingRepository;
import com.lawfirm.lawfirm.repository.ClientRepository;
import com.lawfirm.lawfirm.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CasesHearingsController {

    @Autowired
    private CaseRepository caseRepository;

    @Autowired
    private HearingRepository hearingRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private LawyerRepository lawyerRepository;

    @GetMapping("/cases-hearings")
    public String showCasesAndHearingsForm(Model model) {
        model.addAttribute("legalCase", new LegalCase());
        model.addAttribute("hearing", new Hearing());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("lawyers", lawyerRepository.findAll());
        model.addAttribute("cases", caseRepository.findAll());
        return "cases_hearings";
    }

    @PostMapping("/add-case")
    public String addCase(@ModelAttribute("legalCase") LegalCase newCase,
            @RequestParam("client.id") Long clientId,
            @RequestParam("lawyer.id") Long lawyerId) {

        newCase.setClient(clientRepository.findById(clientId).orElse(null));
        newCase.setLawyer(lawyerRepository.findById(lawyerId).orElse(null));

        caseRepository.save(newCase);

        System.out.println("✅ Case added for client ID: " + clientId);
        return "redirect:/cases-hearings";
    }

    @GetMapping("/cases-report")
    public String viewCasesReport(Model model) {
        model.addAttribute("cases", caseRepository.findAll()); // Fetch all clients
        return "cases_report"; // Must match the file name in templates/
    }


     @GetMapping("/cases/delete/{id}")
    public String deleteCase(@PathVariable Long id) {
        caseRepository.deleteById(id);
        return "redirect:/cases-report";
    }

    // SHOW the edit form
    @GetMapping("/cases/edit/{id}")
    public String showEditCaseForm(@PathVariable Long id, Model model) {
        LegalCase legalcase = caseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid case Id:" + id));
        model.addAttribute("case", legalcase);
        return "edit_case"; // This is the HTML page you'll create
    }

    // PROCESS the update
    @PostMapping("/cases/update/{id}")
    public String updateCase(@PathVariable Long id, @ModelAttribute("case") LegalCase updatedCase) {
        LegalCase legalCase = caseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid case Id:" + id));

        // Update fields
        legalCase.setCaseDetails(updatedCase.getCaseDetails());
        legalCase.setStatus(updatedCase.getStatus());
        legalCase.setFilingDate(updatedCase.getFilingDate());
        legalCase.setClosingDate(updatedCase.getClosingDate());
        // legalCase.setAddress(updatedCase.getAddress());
        caseRepository.save(legalCase);
        return "redirect:/cases-report";
    }




    @PostMapping("/add-hearing")
    public String addHearing(@ModelAttribute("hearing") Hearing newHearing,
            @RequestParam("hearingCase") Long caseId) {
        LegalCase selectedCase = caseRepository.findById(caseId).orElse(null);
        if (selectedCase == null) {
            return "redirect:/cases-hearings?error=invalidCase";
        }

        newHearing.setLegalCase(selectedCase);
        hearingRepository.save(newHearing);
        return "redirect:/cases-hearings";
    }

    @GetMapping("/hearings-report")
    public String viewHearingssReport(Model model) {
        model.addAttribute("hearings", hearingRepository.findAll()); // Fetch all clients
        return "hearings_report"; // Must match the file name in templates/
    }

}
