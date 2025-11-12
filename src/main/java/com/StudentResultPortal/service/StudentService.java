package com.StudentResultPortal.service;

import com.StudentResultPortal.model.Student;
import com.StudentResultPortal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    // Save student
    public Student saveStudent(Student student) {
        if (student.getDate() == null) {
            student.setDate(LocalDate.now());
        }
        if (student.getGrade() == null) {
            student.setMarks(student.getMarks()); // This will trigger grade calculation
        }
        return studentRepository.save(student);
    }
    
    // Delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
    // Get students by name
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
    
    // Get student history (ordered by date)
    public List<Student> getStudentHistory(String name) {
        return studentRepository.findByNameOrderByDateDesc(name);
    }
    
    // Get students by subject
    public List<Student> getStudentsBySubject(String subject) {
        return studentRepository.findBySubject(subject);
    }
}
