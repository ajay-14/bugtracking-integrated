package com.bugtracking.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.dto.ProjectDto;
import com.bugtracking.entities.Employee;
import com.bugtracking.entities.Project;
import com.bugtracking.mapper.ProjectMapper;
import com.bugtracking.repository.IProjectRepository;
import com.bugtracking.services.ProjectServiceImpl;

public class ProjectServiceImplTest {

	@Mock
	IProjectRepository pr;

	@InjectMocks
	ProjectServiceImpl psi;

	@Mock
	ProjectDto projectDto;

	@Mock
	Project project;

	@Mock
	List<ProjectDto> projectDtoList;

	@Mock
	List<Project> projectList;

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

	@Test
	void testbugById() {
		Mockito.when(pr.findById(12l)).thenReturn(Optional.of(project));
		ProjectDto projDto1 = ProjectMapper.toProjectDto(project);
		assertEquals(projDto1.getProjId(), psi.getproject(12l).getProjId());
		Mockito.verify(pr, times(1)).findById(12l);
	}

	@Test
	void testAddBug() {
		Mockito.when(pr.save(any(Project.class))).thenReturn(project);
		Project projectDto2 = psi.createproject(project);
		assertEquals(projectDto2.getProjId(), projectDto2.getProjId());
		Mockito.verify(pr, atLeast(1)).save(any(Project.class));
	}

	@Test
	void testupdateBug() {
		Mockito.when(pr.existsById(12l)).thenReturn(true);
		Mockito.when(pr.save(any(Project.class))).thenReturn(project);
		assertEquals(project.getProjId(),psi.updateproject(12l, project).getProjId());
		Mockito.verify(pr, atLeast(1)).save(any(Project.class));
	}

	@Test
	void testallbugs() {
		Mockito.when(pr.findAll()).thenReturn(projectList);
		assertEquals(projectList, psi.getall());
		Mockito.verify(pr, times(1)).findAll();
	}


	@Test
	void testdeletebyid() {
		Mockito.when(pr.existsById(12l)).thenReturn(true);
		Mockito.when(pr.getById(12l)).thenReturn(project);
		assertEquals(project.getProjId(), psi.deleteproject(12l).getProjId());
		Mockito.verify(pr, times(1)).existsById(12l);
	}

}