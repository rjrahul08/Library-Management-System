package com.backendSpringProject.Librarymanagementsystem.Entity;

import com.backendSpringProject.Librarymanagementsystem.Enum.IssueStatus;
import com.backendSpringProject.Librarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNumber;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;

    @Enumerated(EnumType.STRING)
    private IssueStatus isIssuedOperation;


    private String massage;
    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
