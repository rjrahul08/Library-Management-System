package com.backendSpringProject.Librarymanagementsystem.Repository;

import com.backendSpringProject.Librarymanagementsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
