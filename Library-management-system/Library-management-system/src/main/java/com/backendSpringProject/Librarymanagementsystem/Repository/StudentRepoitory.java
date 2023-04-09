package com.backendSpringProject.Librarymanagementsystem.Repository;

import com.backendSpringProject.Librarymanagementsystem.Entity.Student;
import com.backendSpringProject.Librarymanagementsystem.Enum.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepoitory extends JpaRepository<Student,Integer> {

    Student findByEmail(String email);
    List<Student> findByAge(int age);

    List<Student> findByDepartment(Department department);
}
