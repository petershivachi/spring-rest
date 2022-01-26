package rest.practice.springboot.restdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.practice.springboot.restdemo.entity.Employee;
import rest.practice.springboot.restdemo.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    //Expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/:id")
    public Employee find(long theId){
        return  employeeService.findById(theId);
    }

    @PostMapping("/employees")
    public  void save(Employee theEmployee){
        employeeService.save(theEmployee);
    }

    public void deleteById(Long theId){
        employeeService.deleteById(theId);
    }
}
