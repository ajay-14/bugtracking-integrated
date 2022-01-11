package com.bugtracking.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.controller.ProjectController;
import com.bugtracking.dto.ProjectDto;

import com.bugtracking.entities.Employee;
import com.bugtracking.entities.Project;
import com.bugtracking.services.IProjectService;


public class ProjectControllerTest {
	long projId;
	@Mock
	public ProjectDto projectDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		
		projectDto.setProjId(2);
		projectDto.setProjName("bt");
		projectDto.setProjStatus("open");
		projectDto.setMembers(employeeList);
	}

	@InjectMocks
	ProjectController projectController;

	@Mock
	IProjectService projectService;

	@Mock
	List<Project> projectDtolist;
	@Mock 
	Project project;

	@Test
	void testAddProject() 
	{
		Mockito.when(projectService.createproject(project)).thenReturn(project);
		assertEquals(project,projectController.createproject(project));
		Mockito.verify(projectService).createproject(project);
	}


	@Test
	void updateProject() 
	{
		Mockito.when(projectService.updateproject(projId,project)).thenReturn(project);
		assertEquals(project,projectController.updateproject(projId,project));
		Mockito.verify(projectService).updateproject(projId,project);
	}
	

	@Test
	void deleteProject() 
	{
		Mockito.when(projectService.deleteproject(12)).thenReturn(project);
		assertEquals(project,projectController.deleteproject(12));
		Mockito.verify(projectService).deleteproject(12);

	}

	@Test
	void getProject() 
	{
		Mockito.when(projectService.getproject(projId)).thenReturn(project);
		assertEquals(project,projectController.getproject(projId));
		Mockito.verify(projectService).getproject(projId);
	}
	
	@Test
	void getAllProjects() {
		Mockito.when(projectService.getall()).thenReturn(projectDtolist);
		assertEquals(projectDtolist,projectController.allprojects());
		Mockito.verify(projectService).getall();
	}

}