package com.project.projectmanagement.controllers;

import com.project.projectmanagement.dao.EmployeeRepository;
import com.project.projectmanagement.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  EmployeeRepository empRepo;

  @GetMapping("/new")
  public String displayEmployeeForm(Model model) {
    Employee anEmployee = new Employee();
    model.addAttribute("employee", anEmployee);
    return "new-employee";
  }

  @PostMapping("/save")
  public String createEmployee(Employee employee, Model model) {
    empRepo.save(employee);
    // redirect to prevent duplicate submissions
    return "redirect:/employees/new";
  }
}
