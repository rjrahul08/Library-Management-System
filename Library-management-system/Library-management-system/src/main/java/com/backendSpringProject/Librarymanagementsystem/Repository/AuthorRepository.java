package com.backendSpringProject.Librarymanagementsystem.Repository;

import com.backendSpringProject.Librarymanagementsystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
