package com.netlink.Demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name= "tbl_employee")
public class Employee {
     @Id                              // this notation is used to denote primary key
     @GeneratedValue(strategy= GenerationType.IDENTITY)          // a type of constraint
     private Integer id;

     private String firstName;
     private String lastName;
     private String password;
     private String mobileNum;
     private String userName;

}
