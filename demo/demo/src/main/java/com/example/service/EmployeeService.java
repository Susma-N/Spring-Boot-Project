package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // post the data
    public Employee createEmployee(Employee u) {
        return employeeRepository.save(u);
    }

    // get data
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // update data
    public Employee updateEmployee(int userid, Employee u) {
        Employee employee = employeeRepository.findById(userid).orElse(null);
        if (employee != null) {
            employee.setUserName(u.getUserName());
            employee.setUserAge(u.getUserAge());
            return employeeRepository.save(employee);
        } else {
            return null;
        }
    }

    // get data
    public Employee findEmployee(int userid) {
        return employeeRepository.findById(userid).orElse(null);
    }

    // delete the data
    public void deleteEmployee(int userid) {
        employeeRepository.deleteById(userid);
    }
}
