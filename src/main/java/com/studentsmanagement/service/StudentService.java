package com.studentsmanagement.service;

import com.studentsmanagement.model.Student;
import com.studentsmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    //getall students
    public List<Student> getallstudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByid(String id){
        return studentRepository.findById(id);

    }


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }

    public  List<Student> getstudentbyname(String name){
       return studentRepository.findByName(name);
    }

//    public  List<Student> getStudentbyagegreaterthan(int age){
//            return  studentRepository.findbyagegreaterthan(age);
//    }
//
//
//    public List<Student> getstudentsbycity(String city){
//        return studentRepository.findbycity(city);
//    }


    public  Student getstudentbyemail(String email){
        return studentRepository.findbyemail(email);
    }


//    public List<Student> getstudentbetweenages(int minage,int maxage){
//        return studentRepository.findstudentbetweenage(minage,maxage);
//    }
}
