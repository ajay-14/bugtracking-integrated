package com.bugtracking.services;

import java.util.List;

import com.bugtracking.entities.Project;

public interface IProjectService {

	List<Project> getall();

	Project getproject(long projId);

	Project deleteproject(long projId);

	Project createproject(Project project);

	Project updateproject(long projId, Project p);

}
