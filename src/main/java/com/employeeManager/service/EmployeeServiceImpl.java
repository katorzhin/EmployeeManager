package com.employeeManager.service;

import com.employeeManager.dao.EmployeeDao;
import com.employeeManager.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.employeeDao.updateEmployee(employee);

    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        this.employeeDao.removeEmployee(id);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> employeeList() {
        return this.employeeDao.listEmployees();
    }
}
