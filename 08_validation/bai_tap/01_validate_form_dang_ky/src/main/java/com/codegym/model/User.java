package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 45, message = "must input 5 - 45 characters")
    private String firstName;
    @Size(min = 5, max = 45, message = "must input 5 - 45 characters")
    private String lastName;
    @Pattern(regexp = "\\d{10}", message = "please input enough 10 numbers")
    private String phoneNumb;
//    @Min(18)
    private int age;
    @Email
    @NotEmpty(message = "Not empty")
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//        if (user.age < 18){
//            errors.rejectValue("age", "age.formatAge");
//        }
//    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.age < 18){
            errors.rejectValue("age", "age.formatAge");
        }
    }
//    if(value.equals("")){
//        return false;
//    }else{ LocalDate now = LocalDate.now();
//        LocalDate bd = LocalDate.parse(value);
//        return now.compareTo(bd) - 18 > 0;}
}
