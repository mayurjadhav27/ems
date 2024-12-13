package com.manager.employee.service;

import com.manager.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employeeDto);

    public Employee getEmployeeById(Long employeeId);

    public List<Employee> getEmployees();
    public Employee updateEmployee(Long id,Employee employee);

    public void deleteEmployee(Long id);
}
