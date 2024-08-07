package com.cinzogoni.springsecuritycustomform.controllers;

import com.cinzogoni.springsecuritycustomform.entity.Employee;
import com.cinzogoni.springsecuritycustomform.repositories.EmployeeRepository;
import com.cinzogoni.springsecuritycustomform.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class WebController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    @Autowired
    public WebController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
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
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        employeeRepository.deleteById(theId);
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
    public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
        Optional<Employee> theEmployee = employeeRepository.findById(theId);
        if (theEmployee.isPresent()) {
            theModel.addAttribute("employee", theEmployee.get());
            return "employees/employee-form";
        } else
            return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String searchEmployees(@RequestParam(name = "employeeName", required = false) String employeeName, Model model) {
        List<Employee> employees = employeeService.SearchBy(employeeName);
        model.addAttribute("employees", employees);
        return "employees/employees-list";
    }
}