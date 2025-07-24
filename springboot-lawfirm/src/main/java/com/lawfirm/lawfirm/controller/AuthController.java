package com.lawfirm.lawfirm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Thymeleaf login.html
    }

    // @GetMapping("/role-redirect")
    // public String roleRedirect(Authentication authentication) {
    //     if (authentication.getAuthorities().stream()
    //             .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
    //         return "redirect:/admin/dashboard";
    //     } else if (authentication.getAuthorities().stream()
    //             .anyMatch(a -> a.getAuthority().equals("ROLE_LAWYER"))) {
    //         return "redirect:/admin/dashboard"; // same dashboard for both
    //     }
    //     return "redirect:/login?error=true";
    // }

    @GetMapping("/role-redirect")
    public String roleRedirect(Authentication authentication) {
        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN") || a.getAuthority().equals("ROLE_LAWYER"))) {
            return "redirect:/admin/dashboard"; // same dashboard for both
        }
        return "redirect:/login?error=true";
    }

}
