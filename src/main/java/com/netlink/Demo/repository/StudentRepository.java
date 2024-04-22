package com.netlink.Demo.repository;

import com.netlink.Demo.model.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository   //optional
public interface StudentRepository extends JpaRepository<Student,Integer> , PagingAndSortingRepository<Student,Integer> {
    public Student getStudentByName(String name);
    @Query(value = "select * from springboot.tbl_student where stu_name = ?",nativeQuery = true)
    public List<Student> findStudentUsingNativeQuery(String name);

    @Query(value = "select * from springboot.tbl_student where age=? or stu_name=?",nativeQuery = true)
    public List<Student> getStudentByAgeOrName(Integer age,String name);

}
