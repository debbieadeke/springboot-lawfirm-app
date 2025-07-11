package com.lawfirm.lawfirm.controller;

import com.lawfirm.lawfirm.models.User;
import com.lawfirm.lawfirm.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            if (user.getRole().equals("ADMIN")) return "redirect:/admin/dashboard";
            else return "redirect:/lawyer/dashboard";
        }
        return "redirect:/login?error=true";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
