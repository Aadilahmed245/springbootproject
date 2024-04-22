package com.netlink.Demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name= "tbl_student")
@Data
public class Student {
     @Id                              // this notation is used to denote primary key
     @GeneratedValue(strategy= GenerationType.IDENTITY)          // a type of constraint
     private Integer id;
     @Column(name= "stu_name")
     private String name;
     @Column(name = "stu_email")
     private String email;
     private Integer age;
     private Date dateOfBirth;

     public Student(Integer id, String name, String email, Integer age, Date dateOfBirth) {
          this.id = id;
          this.name = name;
          this.email = email;
          this.age = age;
          this.dateOfBirth = dateOfBirth;
     }
     public Student()
     {

     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     public Date getDateOfBirth() {
          return dateOfBirth;
     }

     public void setDateOfBirth(Date dateOfBirth) {
          this.dateOfBirth = dateOfBirth;
     }
}
