package dev.mcspring.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import dev.mcspring.student.model.Student;
import dev.mcspring.student.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
