package rest.practice.springboot.restdemo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import rest.practice.springboot.restdemo.entity.Employee;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class EmployeeHibernateDAOImpl implements  EmployeeDAO{
    //define field for entity manager
    private EntityManager entityManager;

    @Autowired EmployeeHibernateDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll(){
        //Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //Create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        //Execute query and get result list
        List<Employee>employees = theQuery.getResultList();

        //Return the results
        return employees;
    }

    @Override
    public Employee findById(Long theId){
        //Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //Get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        //Return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee){
        //Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //Save employee
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(Long theId) {
        //Get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //Query to delete an object with the primary key
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        //Execute query
        theQuery.executeUpdate();
    };
}
