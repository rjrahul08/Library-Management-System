package com.backendSpringProject.Librarymanagementsystem.Controller;

import com.backendSpringProject.Librarymanagementsystem.DTO.StudentRequestDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.StudentResponseDto;
import com.backendSpringProject.Librarymanagementsystem.DTO.StudentUpdateEmailDto;
import com.backendSpringProject.Librarymanagementsystem.Entity.Student;
import com.backendSpringProject.Librarymanagementsystem.Enum.Department;
import com.backendSpringProject.Librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto) throws Exception {
        try {
            return studentService.addStudent(studentRequestDto);
        }
        catch (Exception e){
            throw new RuntimeException("Invalid Statement"+e.getMessage());
        }
    }

    @GetMapping("find_by_id")
    public String getStudentById(@RequestParam("id") int id){
        try {
            return studentService.findById(id);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("find_by_email")
    public String getStudentByEmail(@RequestParam("email") String email){
        try {
            return studentService.findByEmail(email);
        }
        catch (Exception e){
            throw new RuntimeException("Not found : "+e.getMessage());
        }
    }
    @GetMapping("/find_by_age")
    public List<Student> getStudentByAge(@RequestParam("age") int age){
        try {
            return studentService.findByAge(age);
        }
        catch (Exception e){
            throw new RuntimeException("Not found : "+e.getMessage());
        }
    }

    @GetMapping("/find_by_department")
    public List<Student> getByDepartment(@RequestParam("department")Department department){
        try {
            return studentService.findByDepartment(department);
        }
        catch (Exception e){
            throw new RuntimeException("Not found : "+e.getMessage());
        }
    }

    @PutMapping("/update_mob")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailDto studentUpdateEmailDto){
        return studentService.updateEmail(studentUpdateEmailDto);
    }
}
