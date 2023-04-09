package com.backendSpringProject.Librarymanagementsystem.Controller;

import com.backendSpringProject.Librarymanagementsystem.DTO.IssueBookRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.IssueBookResponseDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.WithdrawBookRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.WithdrawBookResponseDto;
import com.backendSpringProject.Librarymanagementsystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;





    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        IssueBookResponseDto issueBookResponseDto;
        try {
            issueBookResponseDto =  transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(issueBookResponseDto, HttpStatus.ACCEPTED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdrawBook(@RequestBody WithdrawBookRequestDto withdrawBookRequestDto){
        WithdrawBookResponseDto withdrawBookResponseDto;
        try{
            withdrawBookResponseDto = transactionService.withdrawBook(withdrawBookRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(withdrawBookResponseDto,HttpStatus.ACCEPTED);
    }
}
