package rest.practice.springboot.restdemo.dao;

import rest.practice.springboot.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(Long theId);

    public void save(Employee theEmployee);

    public void deleteById(Long theId);
}
