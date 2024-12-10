package com.manager.employee.service;

import com.manager.employee.entity.Employee;
import com.manager.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employeeDto) {

        Employee savedEmployee= employeeRepository.save(employeeDto);
        return savedEmployee;
    }

}
