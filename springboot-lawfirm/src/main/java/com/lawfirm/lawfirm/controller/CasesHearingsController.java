package com.lawfirm.lawfirm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CasesHearingsController {

    @GetMapping("/cases-hearings")
    public String showCasesAndHearingsPage() {
        return "cases_hearings";  // matches cases_hearings.html in templates
    }
}
