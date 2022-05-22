package com.project.projectmanagement.controllers;

import java.util.List;

import com.project.projectmanagement.dao.ProjectRepository;
import com.project.projectmanagement.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

  @Autowired
  ProjectRepository proRepo;

  @GetMapping
  public String displayProjects(Model model) {
    List<Project> projects = proRepo.findAll();
    model.addAttribute("projects", projects);
    return "list-projects";
  }

  @GetMapping("/new")
  public String displayProjectForm(Model model) {
    // This is to attach an object to our new-project html form
    Project aProject = new Project();
    model.addAttribute("project", aProject);
    return "new-project";
  }

  @PostMapping("/save")
  public String createProject(Project project, Model model) {
    proRepo.save(project);
    // redirect to prevent duplicate submissions
    return "redirect:/projects/new";
  }
}
