package com.backendSpringProject.Librarymanagementsystem.Entity;

import com.backendSpringProject.Librarymanagementsystem.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updationDate;


    @OneToOne
    @JoinColumn
    @JsonIgnore
    Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookIssued = new ArrayList<>();

}
