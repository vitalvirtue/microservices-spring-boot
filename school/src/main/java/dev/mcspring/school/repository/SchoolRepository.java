package dev.mcspring.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mcspring.school.model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
