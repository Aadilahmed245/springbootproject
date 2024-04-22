package com.netlink.Demo.service;

import com.netlink.Demo.dto.EmployeeDTO;
import com.netlink.Demo.mapper.EmployeeMapper;
import com.netlink.Demo.model.Employee;
import com.netlink.Demo.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class EmployeeImp implements IEmployee{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public boolean addEmployee(Employee employee) {
        log.info("info of addEmployee------");
        try {
            employeeRepository.save(employee);
        }catch(Exception e)
        {
            System.out.println("Exception in adding employees");
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.info("info of getAllEmployees------");
        List<Employee> employees=  employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for(Employee employee : employees)
        {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setUserName(employee.getUserName());
            employeeDTOList.add(employeeDTO);
        }
            return employeeDTOList;
    }

    @Override
    public List<EmployeeMapper> getDTO() {
         return employeeRepository.getDTO();
    }
}
