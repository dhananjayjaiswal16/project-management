package com.project.projectmanagement.dao;

import com.project.projectmanagement.entities.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
