package com.studentsmanagement.repository;

import com.studentsmanagement.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@EnableMongoRepositories
public interface StudentRepository  extends MongoRepository<Student,String> {

//    List<Student> findByName(String name);
//    List<Student> findbyagegreaterthan(int age);
//    List<Student> findbycity(String city);


    @Query("{'email':?0}")
    Student findbyemail(String email);


    @Query("{'age' : {$gte: ? 0, $lte:? 1} }")
    List<Student> findstudentbetweenage(int minage,int maxage);

}
