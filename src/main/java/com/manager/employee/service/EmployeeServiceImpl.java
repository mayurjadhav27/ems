package com.manager.employee.service;

import com.manager.employee.entity.Employee;
import com.manager.employee.exception.ResourceNotFoundException;
import com.manager.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employeeDto) {

        Employee savedEmployee= employeeRepository.save(employeeDto);
        return savedEmployee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee" +
                " does not exist with given Id:"+employeeId));
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employee1=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee dow not exist with given EmployeeId:"+id));
        employee1.setEmail(employee.getEmail());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());

        return  employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee is not present"));
        employeeRepository.deleteById(id);
    }

}
