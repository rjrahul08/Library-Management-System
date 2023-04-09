package com.backendSpringProject.Librarymanagementsystem.Controller;

import com.backendSpringProject.Librarymanagementsystem.DTO.AuthorRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.AuthorResponseDto;
import com.backendSpringProject.Librarymanagementsystem.Entity.Author;
import com.backendSpringProject.Librarymanagementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }
    @GetMapping("/get_authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
}
