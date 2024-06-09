package dev.mcspring.school.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolDTO {
    private String name;
    private String email;
    private List<Student> students;
}
