package com.netlink.Demo.service;

import com.netlink.Demo.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStudent {



    Boolean saveStudentInfo(Student student) throws Exception;

    void deleteStudent(Integer id);


    List<Student> getAllStudent();

    Student updateStudentById(Student student);

    List<Student> getStudentsWithPagination(Integer offset, Integer pageSize);

    List<Student> getSortedStudents(String property);

    Student getStudentById(Integer id);

    Student getStudentByName(String name);

    List<Student> getStudentByNativeQuery(String name);

    List<Student> getStudentByAgeOrName(Integer age, String name);
}
