package com.backendSpringProject.Librarymanagementsystem.Service;

import com.backendSpringProject.Librarymanagementsystem.DTO.AuthorRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.AuthorResponseDto;
import com.backendSpringProject.Librarymanagementsystem.Entity.Author;
import com.backendSpringProject.Librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());
        author.setMobileNo(authorRequestDto.getMobileNo());
        authorRepository.save(author);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setMobileNo(author.getMobileNo());
        return authorResponseDto;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
