package com.example.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.mvc.model.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {}
