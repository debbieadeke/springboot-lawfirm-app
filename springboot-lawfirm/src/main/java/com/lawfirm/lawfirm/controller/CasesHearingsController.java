package com.lawfirm.lawfirm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.lawfirm.lawfirm.models.Case;
import com.lawfirm.lawfirm.models.Hearing;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CasesHearingsController {

    @GetMapping("/cases-hearings")
    public String showCasesAndHearingsForm(Model model) {
        model.addAttribute("case", new Case());
        model.addAttribute("hearing", new Hearing());
        return "cases_hearings"; // Your HTML file
    }

    @PostMapping("/add-case")
    public String addCase(@ModelAttribute("case") Case newCase) {
        System.out.println("Case added for client: " + newCase.getClientId());
        // Save to DB later
        return "redirect:/cases-hearings";
    }

    @PostMapping("/add-hearing")
    public String addHearing(@ModelAttribute("hearing") Hearing newHearing) {
        System.out.println("Hearing added for case ID: " + newHearing.getCaseId());
        // Save to DB later
        return "redirect:/cases-hearings";
    }
}
