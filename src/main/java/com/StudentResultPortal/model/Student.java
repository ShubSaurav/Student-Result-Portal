package com.StudentResultPortal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String subject;
    
    @Column(nullable = false)
    private Integer marks;
    
    @Column(nullable = false)
    private String grade;
    
    @Column(nullable = false)
    private LocalDate date;
    
    @Column(nullable = false)
    private String className;
    
    @Column(nullable = false)
    private String section;
    
    // Constructors
    public Student() {
    }
    
    public Student(String name, String subject, Integer marks, String grade, LocalDate date, String className, String section) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
        this.date = date;
        this.className = className;
        this.section = section;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public Integer getMarks() {
        return marks;
    }
    
    public void setMarks(Integer marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getClassName() {
        return className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getSection() {
        return section;
    }
    
    public void setSection(String section) {
        this.section = section;
    }
    
    // Helper method to calculate grade based on marks
    private String calculateGrade(Integer marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
}
