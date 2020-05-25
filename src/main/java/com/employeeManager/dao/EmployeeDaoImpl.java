package com.employeeManager.dao;

import com.employeeManager.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("Employee successfully saved. Book details: " + employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
        logger.info("Employee successfully update. Book details: " + employee);
    }

    @Override
    public void removeEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, id);

        if (employee != null) {
            session.delete(employee);
        }
        logger.info("Employee successfully removed. Book details: " + employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, id);
        logger.info("Employee successfully loaded. Book details: " + employee);
        return employee;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        for (Employee employee : employeeList) {
            logger.info("Employee list " + employee);
        }
        return employeeList;
    }
}
