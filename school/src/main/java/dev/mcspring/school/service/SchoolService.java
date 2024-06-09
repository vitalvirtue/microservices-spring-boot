package dev.mcspring.school.service;

import dev.mcspring.school.dto.SchoolDTO;
import dev.mcspring.school.model.School;
import dev.mcspring.school.repository.SchoolRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public School findById(Integer id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public void delete(Integer id) {
        schoolRepository.deleteById(id);
    }

    public SchoolDTO findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return SchoolDTO.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
