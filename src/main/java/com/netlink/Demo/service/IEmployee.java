package com.netlink.Demo.service;

import com.netlink.Demo.dto.EmployeeDTO;
import com.netlink.Demo.mapper.EmployeeMapper;
import com.netlink.Demo.model.Employee;

import java.util.List;

public interface IEmployee {

     

    boolean addEmployee(Employee employee);

    List<EmployeeDTO> getAllEmployees();

    List<EmployeeMapper> getDTO();
}
