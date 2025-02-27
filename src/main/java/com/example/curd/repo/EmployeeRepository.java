package com.example.curd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curd.mode.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}