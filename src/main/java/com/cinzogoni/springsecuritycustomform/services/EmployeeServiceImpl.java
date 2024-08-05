package com.cinzogoni.springsecuritycustomform.services;

import com.cinzogoni.springsecuritycustomform.entity.Employee;
import com.cinzogoni.springsecuritycustomform.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> SearchBy(String theName) {

        if (theName != null && !theName.trim().isEmpty()) {
            return employeeRepository.findByFirstNameContainsOrLastNameAllIgnoreCase(theName, theName);
        }
        else {
            return findAll();
        }
    }
}
