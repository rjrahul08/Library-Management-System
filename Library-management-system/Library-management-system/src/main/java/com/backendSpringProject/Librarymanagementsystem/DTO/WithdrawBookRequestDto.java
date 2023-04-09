package com.backendSpringProject.Librarymanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WithdrawBookRequestDto {
    private int bookId;
    private int cardId;
}
