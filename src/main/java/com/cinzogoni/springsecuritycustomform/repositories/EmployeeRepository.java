package com.cinzogoni.springsecuritycustomform.repositories;

import com.cinzogoni.springsecuritycustomform.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();

    List<Employee> findByFirstNameContainsOrLastNameAllIgnoreCase(String firstName, String lastName);

}

