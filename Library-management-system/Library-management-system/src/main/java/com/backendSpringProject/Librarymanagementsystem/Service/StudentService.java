package com.backendSpringProject.Librarymanagementsystem.Service;

import com.backendSpringProject.Librarymanagementsystem.DTO.StudentRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.StudentResponseDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.StudentUpdateEmailDto;
import com.backendSpringProject.Librarymanagementsystem.Entity.LibraryCard;
import com.backendSpringProject.Librarymanagementsystem.Entity.Student;
import com.backendSpringProject.Librarymanagementsystem.Enum.CardStatus;
import com.backendSpringProject.Librarymanagementsystem.Enum.Department;
import com.backendSpringProject.Librarymanagementsystem.Repository.StudentRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepoitory studentRepoitory;
    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) throws Exception {
        try {
            Student student = new Student();
            student.setAge(studentRequestDto.getAge());
            student.setName(studentRequestDto.getName());
            student.setEmail(studentRequestDto.getEmail());
            student.setDepartment(studentRequestDto.getDepartment());

            //create a card object
            LibraryCard card = new LibraryCard();
            card.setStatus(CardStatus.ACTIVATED);
            card.setStudent(student);

            student.setLibraryCard(card);

            studentRepoitory.save(student);

            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setName(student.getName());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setId(student.getId());

            return studentResponseDto;
        }
        catch (Exception e){
            throw new Exception("Invalid Input");
        }

    }

    public String findById(int id) {
        Student student = studentRepoitory.findById(id).get();
        return student.getName();
    }

    public String findByEmail(String email) {
        Student student = studentRepoitory.findByEmail(email);
        return student.getName();
    }

    public List<Student> findByAge(int age) {

        Student student;
        List<Student> studentList = studentRepoitory.findByAge(age);
        return studentList;
    }

    public List<Student> findByDepartment(Department department) {
        List<Student> studentList = studentRepoitory.findByDepartment(department);
        return studentList;
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailDto studentUpdateEmailDto) {
        Student student = studentRepoitory.findById(studentUpdateEmailDto.getId()).get();
        student.setEmail(studentUpdateEmailDto.getEmail());

        Student updatedStudent = studentRepoitory.save(student);


        //  convert updated student to response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return studentResponseDto;
    }
}
