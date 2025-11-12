package com.StudentResultPortal.controller;

import com.StudentResultPortal.model.User;
import com.StudentResultPortal.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("user", new User());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                       @RequestParam String password,
                       HttpSession session,
                       Model model) {
        if (userService.authenticate(username, password)) {
            User user = userService.findByUsername(username).get();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            model.addAttribute("user", new User());
            return "login";
        }
    }
    
        @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, 
                              @RequestParam(required = false) String confirmPassword,
                              Model model) {
        // Validate passwords match
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            model.addAttribute("user", user);
            return "signup";
        }
        
        // Validate student fields
        if ("STUDENT".equals(user.getRole())) {
            if (user.getClassName() == null || user.getClassName().isEmpty()) {
                model.addAttribute("error", "Class is required for students!");
                model.addAttribute("user", user);
                return "signup";
            }
            if (user.getSection() == null || user.getSection().isEmpty()) {
                model.addAttribute("error", "Section is required for students!");
                model.addAttribute("user", user);
                return "signup";
            }
        } else {
            // Clear student fields for teachers
            user.setClassName(null);
            user.setSection(null);
        }
        
        try {
            userService.registerUser(user);
            model.addAttribute("success", "Account created successfully! Please login.");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user);
            return "signup";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("user", user);
        
        if ("TEACHER".equals(user.getRole())) {
            return "redirect:/";
        } else {
            return "redirect:/my-results";
        }
    }
}
