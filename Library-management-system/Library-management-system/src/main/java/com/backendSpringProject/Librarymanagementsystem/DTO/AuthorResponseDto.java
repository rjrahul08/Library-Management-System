package com.backendSpringProject.Librarymanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {
    private String name;
    private String email;
    private String mobileNo;
}
