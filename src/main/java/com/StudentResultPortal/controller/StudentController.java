package com.StudentResultPortal.controller;

import com.StudentResultPortal.model.Student;
import com.StudentResultPortal.model.User;
import com.StudentResultPortal.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    // Home page - Display all students
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        if (!"TEACHER".equals(user.getRole())) {
            return "redirect:/my-results";
        }
        
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("title", "Student Results Portal - All Results");
        model.addAttribute("students", students);
        model.addAttribute("user", user);
        return "student";
    }
    
    // Show upload form
    @GetMapping("/upload")
    public String showUploadForm(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"TEACHER".equals(user.getRole())) {
            return "redirect:/login";
        }
        
        model.addAttribute("title", "Upload New Result");
        model.addAttribute("student", new Student());
        model.addAttribute("user", user);
        return "upload";
    }
    
    // Handle form submission
    @PostMapping("/upload")
    public String uploadResult(@ModelAttribute Student student, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"TEACHER".equals(user.getRole())) {
            return "redirect:/login";
        }
        
        student.setDate(LocalDate.now());
        studentService.saveStudent(student);
        return "redirect:/";
    }
    
    // View student history
    @GetMapping("/history")
    public String viewHistory(@RequestParam String name, Model model) {
        List<Student> students = studentService.getStudentHistory(name);
        model.addAttribute("title", "Result History for " + name);
        model.addAttribute("students", students);
        return "student";
    }
    
    // Generate report (example: all students)
    @GetMapping("/report")
    public String generateReport(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("title", "Student Report - All Results");
        model.addAttribute("students", students);
        return "student";
    }
    
    // Search by subject
    @GetMapping("/subject/{subject}")
    public String getBySubject(@PathVariable String subject, Model model) {
        List<Student> students = studentService.getStudentsBySubject(subject);
        model.addAttribute("title", "Results for Subject: " + subject);
        model.addAttribute("students", students);
        return "student";
    }
    
    // Delete student result
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"TEACHER".equals(user.getRole())) {
            return "redirect:/login";
        }
        
        studentService.deleteStudent(id);
        return "redirect:/";
    }
    
    // Student dashboard - View own results
    @GetMapping("/my-results")
    public String myResults(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        
        if (!"STUDENT".equals(user.getRole())) {
            return "redirect:/";
        }
        
        // Get student's results by their name
        List<Student> studentResults = studentService.getStudentHistory(user.getFullName());
        
        // Calculate statistics
        int totalSubjects = studentResults.size();
        double averageMarks = 0;
        int highestScore = 0;
        
        if (!studentResults.isEmpty()) {
            int totalMarks = 0;
            for (Student result : studentResults) {
                totalMarks += result.getMarks();
                if (result.getMarks() > highestScore) {
                    highestScore = result.getMarks();
                }
            }
            averageMarks = (double) totalMarks / totalSubjects;
        }
        
        model.addAttribute("user", user);
        model.addAttribute("students", studentResults);
        model.addAttribute("totalSubjects", totalSubjects);
        model.addAttribute("averageMarks", averageMarks);
        model.addAttribute("highestScore", highestScore);
        
        return "my-results";
    }
}
