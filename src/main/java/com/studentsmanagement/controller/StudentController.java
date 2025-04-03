package com.studentsmanagement.controller;

import com.studentsmanagement.model.Student;
import com.studentsmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
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
    public Student getStudentbyid(@PathVariable String id){
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


//    @GetMapping("/name/{name}")
//    public List<Student> getstudentbyname(@PathVariable  String name){
//        return studentService.getstudentbyname(name);
//    }

    @GetMapping("/email/{email}")
    public Student getstudentbyemail(@PathVariable String email){
        return studentService.getstudentbyemail(email);
    }

//   @GetMapping("/age/{age}")
//   public List<Student> getstudentagegreater(@PathVariable int age){
//        return studentService.getStudentbyagegreaterthan(age);
//   }


//    @GetMapping
//    public List<Student> getstudentbycity(@PathVariable String city){
//        return studentService.getstudentsbycity(city);
//    }


    @GetMapping("/agerange/{min}/{max}")
    public List<Student> getstudentbetweenages(@PathVariable int min, @PathVariable int max){

        return studentService.getstudentbetweenages(min,max);
    }




}
