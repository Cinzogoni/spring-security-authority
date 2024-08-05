package com.cinzogoni.springsecuritycustomform.services;

import com.cinzogoni.springsecuritycustomform.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    void save(Employee employee);

    void deleteById(int id);

    List<Employee> SearchBy(String theName);
}
