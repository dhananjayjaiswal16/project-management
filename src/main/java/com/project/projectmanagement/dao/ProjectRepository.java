package com.project.projectmanagement.dao;

import java.util.List;

import com.project.projectmanagement.entities.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
  @Override
  public List<Project> findAll();
}
