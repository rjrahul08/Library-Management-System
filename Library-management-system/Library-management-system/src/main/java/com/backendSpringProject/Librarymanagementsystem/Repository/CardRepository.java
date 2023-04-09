package com.backendSpringProject.Librarymanagementsystem.Repository;

import com.backendSpringProject.Librarymanagementsystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
