package com.netlink.Demo.controller;

import com.netlink.Demo.dto.EmployeeDTO;
import com.netlink.Demo.mapper.EmployeeMapper;
import com.netlink.Demo.model.Employee;
import com.netlink.Demo.service.IEmployee;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Log4j2
public class EmployeeController {
    @Autowired
    private IEmployee employeeService;
    @PutMapping("/add-employee")
    public boolean addEmployee(@RequestBody Employee employee)
    {
        log.trace("Entered inside addEmployee");
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/get-all-employees")
    public List<EmployeeDTO> getAllEmployees() {
        log.trace("Entered inside getAllEmployees");
        return employeeService.getAllEmployees();
    }
    @GetMapping("/get-error")
    public Integer getError()
    {
        int a=10/0;
        return a;
    }
    @GetMapping("/get-dto")
    public List<EmployeeDTO> getDTO()
    {
        List<EmployeeMapper> employeeMappers=  employeeService.getDTO();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(EmployeeMapper employeeMapper : employeeMappers)
        {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employeeMapper.getId());
            employeeDTO.setFirstName(employeeMapper.getFirst_Name());
            employeeDTO.setLastName(employeeMapper.getLast_Name());
            employeeDTO.setUserName(employeeMapper.getUser_Name());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
//    @ExceptionHandler(value = ArithmeticException.class)
//    public ResponseEntity<String> getArithmeticException()
//    {
//        String body = "Arithmetic Exception Occured!";
//        return ResponseEntity.ok(body);
//    }
}
