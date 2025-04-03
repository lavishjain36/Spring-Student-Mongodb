package com.studentsmanagement.service;

import com.studentsmanagement.exception.StudentNotFoundException;
import com.studentsmanagement.model.Student;
import com.studentsmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    //getall students
    public List<Student> getallstudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByid(String id){
        return studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with ID"+id+"Not found."));

    }


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(String id){
//        studentRepository.deleteById(id);
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Student with id "+id+"Not found for deletion.");
        }
        studentRepository.deleteById(id);
    }

//    public  List<Student> getstudentbyname(String name){
//       return studentRepository.findByName(name);
//    }

//    public  List<Student> getStudentbyagegreaterthan(int age){
//            return  studentRepository.findbyagegreaterthan(age);
//    }

//    public List<Student> getstudentsbycity(String city){
//        return studentRepository.findbycity(city);
//    }


    public  Student getstudentbyemail(String email){
        Student student = studentRepository.findbyemail(email);
        if(student==null){
            throw  new StudentNotFoundException("No Student with the email exist"+email);
        }
        return student;
    }


    public List<Student> getstudentbetweenages(int minage,int maxage){
        List<Student> students = studentRepository.findstudentbetweenage(minage, maxage);
        if(students.isEmpty()){
            throw  new StudentNotFoundException("No Student found between ages "+minage+"and "+maxage);
        }
        return students;
    }
}
