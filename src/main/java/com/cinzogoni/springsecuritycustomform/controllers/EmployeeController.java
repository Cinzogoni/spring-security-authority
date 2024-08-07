package com.cinzogoni.springsecuritycustomform.controllers;

import com.cinzogoni.springsecuritycustomform.entity.Employee;
import com.cinzogoni.springsecuritycustomform.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/form")
    public String showForm(@ModelAttribute("employee") Employee employee) {
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.delete(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/list")
    public String employeeList(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees/employees-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee theEmployee = new Employee();
        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        Optional<Employee> theEmployee = employeeRepository.findById(theId);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
}
