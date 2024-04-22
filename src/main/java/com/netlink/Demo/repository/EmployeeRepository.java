package com.netlink.Demo.repository;

import com.netlink.Demo.mapper.EmployeeMapper;
import com.netlink.Demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select id,first_Name,last_Name,user_Name from springboot.tbl_employee",nativeQuery = true)
    List<EmployeeMapper> getDTO();
}
