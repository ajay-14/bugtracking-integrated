package com.bugtracking.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.controller.BugController;
import com.bugtracking.dto.BugDto;
import com.bugtracking.entities.Bug;
import com.bugtracking.entities.Employee;
import com.bugtracking.entities.Project;
import com.bugtracking.enums.bugstatus;
import com.bugtracking.services.IBugService;

public class BugControllerTest {
	long bugId;
	@Mock
	public BugDto bugDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Project project = new Project();
		project.setProjId(12);

		Employee e = new Employee();
		e.setEmpId(83);

		bugDto.setBugId(12);
		bugDto.setBugDescription("aaa");
		bugDto.setEndDate(null);
		bugDto.setBugPriority("ss");
		bugDto.setProject(project);
		bugDto.setStartDate(null);
		bugDto.setBugStatus(bugstatus.OPEN);
		bugDto.setBugType("sss");
		bugDto.setEmployee(e);
	}

	@InjectMocks
	BugController bugcontroller;

	@Mock
	IBugService bugservice;

	@Mock
	List<BugDto> bugDtolist;
	@Mock
	Bug bug;

	@Test
	void testAddBug() {
		Mockito.when(bugservice.createbug(bugDto)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.createbug(bugDto));
		Mockito.verify(bugservice,times(1)).createbug(bugDto);
	}

	@Test
	void testdelbug() {
		when(bugservice.deletebug(bugId)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.deletebug(bugId));
		Mockito.verify(bugservice, times(1)).deletebug(bugId);
	}

	@Test
	void testupdateBug() {
		Mockito.when(bugservice.updatebug(bugId, bugDto)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.updatebug(bugId, bugDto));
		Mockito.verify(bugservice,times(1)).updatebug(bugId, bugDto);
	}

	@Test
	void testgetbug() {
		Mockito.when(bugservice.getbug(bugId)).thenReturn(bugDto);
		assertEquals(bugDto, bugcontroller.getbug(bugId));
		Mockito.verify(bugservice,times(1)).getbug(bugId);
	}

	@Test
	void testgetallbug() {
		Mockito.when(bugservice.getall()).thenReturn(bugDtolist);
		assertEquals(bugDtolist, bugcontroller.allbugs());
		Mockito.verify(bugservice,times(1)).getall();
	}

	@Test
	void testgetbugbystatus() {
		Mockito.when(bugservice.getbugsbystatus(bugstatus.OPEN)).thenReturn(bugDtolist);
		assertEquals(bugDtolist, bugcontroller.bugsbystatus(bugstatus.OPEN));
		Mockito.verify(bugservice,times(1)).getbugsbystatus(bugstatus.OPEN);
	}

}
