package com.example.curd.cont;

import com.example.curd.mode.Employee;
import com.example.curd.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All Employees
    @GetMapping("/get")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee by ID
    @GetMapping("get/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id);
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setSalary(updatedEmployee.getSalary());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with ID: " + id;
    }
}

