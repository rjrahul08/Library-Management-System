package com.backendSpringProject.Librarymanagementsystem.Service;

import com.backendSpringProject.Librarymanagementsystem.DTO.BookRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.BookResponseDto;
import com.backendSpringProject.Librarymanagementsystem.Entity.Author;
import com.backendSpringProject.Librarymanagementsystem.Entity.Book;
import com.backendSpringProject.Librarymanagementsystem.Enum.IssueStatus;
import com.backendSpringProject.Librarymanagementsystem.Repository.AuthorRepository;
import com.backendSpringProject.Librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto) {

        // get author object
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIsIssued(IssueStatus.FALSE);
        book.setAuthor(author);

        author.getBooks().add(book);

        authorRepository.save(author);

        // create a response dto
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;
    }
}
