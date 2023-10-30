package com.olemukan.employeemanager.service;

import com.olemukan.employeemanager.exception.UserNotFoundException;
import com.olemukan.employeemanager.model.Employee;
import com.olemukan.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);

    }

    public Optional<Employee> findEmployeeById(Long id){
        return Optional.ofNullable(employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user doesn't exist")));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
