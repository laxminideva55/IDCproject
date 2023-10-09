package com.example.project.controller;

import com.example.project.Repository.StudentRepository;
import com.example.project.Services.StudentService;
import com.example.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/getBySkills")
    public ResponseEntity<List<String>> getRollNumbersBySkills(@RequestParam List<String> skills) {
        List<String> rollNumbers = studentService.getRollNumbersBySkills(skills);

        if (rollNumbers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rollNumbers);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getByInternshipRole")
    public List<String> getRollNumbersByInternshipRole(String internshipRole) {
        return studentRepository.findRollNumbersByInternshipRole(internshipRole);
    }

    @GetMapping("/getByInternshipCompany")
    public ResponseEntity<List<String>> getRollNumbersByInternshipCompany(@RequestParam String company) {
        List<String> rollNumbers = studentService.getRollNumbersByInternshipCompany(company);

        if (rollNumbers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rollNumbers);
    }

    @GetMapping("/getByCGPA")
    public ResponseEntity<List<String>> getRollNumbersByCGPA(@RequestParam Double cgpa) {
        List<String> rollNumbers = studentService.getRollNumbersByCGPA(cgpa);

        if (rollNumbers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rollNumbers);

    }

    @GetMapping("/getByCertificateIssuer")
    public ResponseEntity<List<String>> getRollNumbersByCertificateIssuer(@RequestParam String issuer) {
        List<String> rollNumbers = studentService.getRollNumbersByCertificateIssuer(issuer);

        if (rollNumbers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(rollNumbers);
    }





}
