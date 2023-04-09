package com.backendSpringProject.Librarymanagementsystem.Service;

import com.backendSpringProject.Librarymanagementsystem.DTO.IssueBookRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.IssueBookResponseDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.WithdrawBookRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.WithdrawBookResponseDto;
import com.backendSpringProject.Librarymanagementsystem.Entity.Book;
import com.backendSpringProject.Librarymanagementsystem.Entity.LibraryCard;
import com.backendSpringProject.Librarymanagementsystem.Entity.Transaction;
import com.backendSpringProject.Librarymanagementsystem.Enum.CardStatus;
import com.backendSpringProject.Librarymanagementsystem.Enum.IssueStatus;
import com.backendSpringProject.Librarymanagementsystem.Enum.TransactionStatus;
import com.backendSpringProject.Librarymanagementsystem.Repository.BookRepository;
import com.backendSpringProject.Librarymanagementsystem.Repository.CardRepository;
import com.backendSpringProject.Librarymanagementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    JavaMailSender emailSender;


    @Autowired
    TransactionRepository transactionRepository1;

    @Autowired
    CardRepository cardRepository1;

    @Autowired
    BookRepository bookRepository1;

    @Autowired
    JavaMailSender emailSender1;

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIsIssuedOperation(IssueStatus.TRUE);

        LibraryCard card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Invalid card ID");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card Id");
        }
        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Invalid Book ID");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }
        if(card.getStatus()  != CardStatus.ACTIVATED ){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not activated");
        }
        if(book.getIsIssued() == IssueStatus.TRUE){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Sorry! Book is already issued...");
            transactionRepository.save(transaction);
            throw new Exception("Sorry! Book is already issued...");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMassage("Transaction was successful");
        transaction.setBook(book);
        transaction.setCard(card);
        transactionRepository.save(transaction);

        book.setIsIssued(IssueStatus.TRUE);
        book.setCard(card);
        book.getTransaction().add(transaction);
        card.getTransactionList().add(transaction);
        card.getBookIssued().add(book);


        cardRepository.save(card);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setTransanctionId(transaction.getTransactionNumber());
        issueBookResponseDto.setBookName(book.getTitle());


//        String text = "Congrats !!"+card.getStudent().getName()+"  You has been issued "+book.getTitle();
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("backendrahul986@gmail.com ");
//        message.setTo(card.getStudent().getEmail());
//        message.setSubject("Issue Book Notification");
//        message.setText(text);
//        emailSender.send(message);

        return issueBookResponseDto;
    }

    public WithdrawBookResponseDto withdrawBook(WithdrawBookRequestDto withdrawBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIsIssuedOperation(IssueStatus.TRUE);
        LibraryCard card;
        try{
            card = cardRepository1.findById(withdrawBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Invalid card ID");
            transactionRepository1.save(transaction);
            throw new Exception("Invalid card Id");
        }
        Book book;
        try{
            book = bookRepository1.findById(withdrawBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Invalid Book ID");
            transactionRepository1.save(transaction);
            throw new Exception("Invalid Book Id");
        }
        if(card.getStatus()  != CardStatus.ACTIVATED ){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Your card is not activated");
            transactionRepository1.save(transaction);
            throw new Exception("Your card is not activated");
        }
        if(book.getIsIssued() == IssueStatus.FALSE){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Sorry! Book is not issued...");
            transactionRepository1.save(transaction);
            throw new Exception("Sorry! Book is not issued...");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMassage("Transaction was successful");
        transaction.setBook(book);
        transaction.setCard(card);
        transactionRepository1.save(transaction);

        book.setIsIssued(IssueStatus.FALSE);
        book.setCard(card);
        book.getTransaction().remove(transaction);
        card.getTransactionList().remove(transaction);
        card.getBookIssued().remove(book);


        cardRepository1.save(card);

        WithdrawBookResponseDto withdrawBookResponseDto = new WithdrawBookResponseDto();
        withdrawBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        withdrawBookResponseDto.setTransanctionId(transaction.getTransactionNumber());
        withdrawBookResponseDto.setBookName(book.getTitle());

//        String text = "Congrats !!"+card.getStudent().getName()+"  You has been withdraw "+book.getTitle();
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("backendrahul986@gmail.com ");
//        message.setTo(card.getStudent().getEmail());
//        message.setSubject("Issue Book Notification");
//        message.setText(text);
//        emailSender.send(message);

        return withdrawBookResponseDto;
    }
}
