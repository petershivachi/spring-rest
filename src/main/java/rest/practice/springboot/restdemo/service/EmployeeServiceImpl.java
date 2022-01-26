package rest.practice.springboot.restdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.practice.springboot.restdemo.dao.EmployeeDAO;
import rest.practice.springboot.restdemo.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public  EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(Long theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    };

    @Override
    @Transactional
    public void deleteById(Long theId) {
        employeeDAO.deleteById(theId);
    }
}
