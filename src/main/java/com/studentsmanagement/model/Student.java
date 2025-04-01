package com.studentsmanagement.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    @NotBlank(message = "Name field cannot empty")
    @Size(min = 2, max = 30, message = "Name must be between 2 to 30 characters.")
    private  String name;

    @Min(value = 18,message = "Age must be atleast 18")
    @Max(value = 60,message = "Age must be less than 60")
    private  int age;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

//    private  String city;
}
