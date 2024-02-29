package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/insertdata")
    public Employee insert(@RequestBody Employee u) {
        return employeeService.createEmployee(u);
    }

    @GetMapping("/getdata")
    public List<Employee> get() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{userid}")
    public Employee get(@PathVariable int userid) {
        return employeeService.findEmployee(userid);
    }

    @PutMapping("/updatedata/{userid}")
    public Employee update(@PathVariable int userid, @RequestBody Employee u) {
        return employeeService.updateEmployee(userid, u);
    }

    @DeleteMapping("/deletedata/{userid}")
    public void delete(@PathVariable int userid) {
        employeeService.deleteEmployee(userid);
    }

}
