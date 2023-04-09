package com.backendSpringProject.Librarymanagementsystem.DTO;

import com.backendSpringProject.Librarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto {
    private String transanctionId;

    private String bookName;

    private TransactionStatus transactionStatus;
}
