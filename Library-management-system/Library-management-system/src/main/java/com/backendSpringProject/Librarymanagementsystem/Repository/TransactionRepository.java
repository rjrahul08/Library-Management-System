package com.backendSpringProject.Librarymanagementsystem.Repository;

import com.backendSpringProject.Librarymanagementsystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
