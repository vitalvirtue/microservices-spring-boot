package dev.mcspring.student.controller;

import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import dev.mcspring.student.model.Student;
import dev.mcspring.student.service.StudentService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/school/{schoolId}")
    public List<Student> findAllStudentsBySchool(@PathVariable Integer schoolId) {
        return studentService.findAllStudentsBySchool(schoolId);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        URI location = UriComponentsBuilder.fromPath("/api/v1/students/{id}")
                .buildAndExpand(savedStudent.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        student.setId(id);
        Student updatedStudent = studentService.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
} 
