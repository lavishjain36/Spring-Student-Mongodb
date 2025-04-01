package com.studentsmanagement.controller;

import com.studentsmanagement.model.Student;
import com.studentsmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService  studentService;

    @GetMapping
    public List<Student> getallstudents(){
        return studentService.getallstudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentbyid(@PathVariable String id){
        return studentService.getStudentByid(id);
    }

    @PostMapping
    public Student addstudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deletestudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }


    @GetMapping("/name/{name}")
    public List<Student> getstudentbyname(@PathVariable  String name){
        return studentService.getstudentbyname(name);
    }

    @GetMapping("/email/{email}")
    public Student getstudentbyemail(@PathVariable String email){
        return studentService.getstudentbyemail(email);
    }


}
