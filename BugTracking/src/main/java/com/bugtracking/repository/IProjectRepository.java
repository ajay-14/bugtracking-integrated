package com.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.entities.Project;

@Repository("rs")
public interface IProjectRepository extends JpaRepository<Project, Long>{

}
