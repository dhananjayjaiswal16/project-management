package com.project.projectmanagement.controllers;

import java.util.List;

import com.project.projectmanagement.dao.EmployeeRepository;
import com.project.projectmanagement.dao.ProjectRepository;
import com.project.projectmanagement.entities.Employee;
import com.project.projectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Autowired
  ProjectRepository proRepo;
  @Autowired
  EmployeeRepository empRepo;

  @GetMapping("/")
  public String displayHome(Model model) {
    // fetching projects on homepage
    List<Project> projects = proRepo.findAll();
    model.addAttribute("projects", projects);
    // fetching employees on homepage
    List<Employee> employees = empRepo.findAll();
    model.addAttribute("employees", employees);
    return "home";
  }
}
