package com.backendSpringProject.Librarymanagementsystem.Entity;

import com.backendSpringProject.Librarymanagementsystem.Enum.Genre;
import com.backendSpringProject.Librarymanagementsystem.Enum.IssueStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int price;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private IssueStatus isIssued;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transaction = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;

}
