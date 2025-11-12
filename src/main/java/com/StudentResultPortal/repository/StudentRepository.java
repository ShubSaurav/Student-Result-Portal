package com.StudentResultPortal.repository;

import com.StudentResultPortal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find students by name
    List<Student> findByName(String name);
    
    // Find students by subject
    List<Student> findBySubject(String subject);
    
    // Find students by name ordered by date
    List<Student> findByNameOrderByDateDesc(String name);
}
