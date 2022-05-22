package com.project.projectmanagement.controllers;

import com.project.projectmanagement.entities.Project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
  @RequestMapping("/new")
  public String displayProjectForm(Model model) {
    // This is to attach an object to our new-project html form
    Project aProject = new Project();
    model.addAttribute("project", aProject);
    return "new-project";
  }
}
