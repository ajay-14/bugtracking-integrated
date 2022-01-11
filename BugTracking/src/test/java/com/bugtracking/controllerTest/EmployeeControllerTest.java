package com.bugtracking.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.controller.EmployeeController;
import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.entities.Employee;
import com.bugtracking.services.IEmployeeService;

public class EmployeeControllerTest {
	long empId;
	@Mock
	public EmployeeDto employeeDto;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		employeeDto.setEmpId(1);
		employeeDto.setEmpName("aravi");
		employeeDto.setEmpEmail("aravi@gmail.com");
		employeeDto.setEmpContactNo("8123456789");
		employeeDto.setProjectId(321);
	}

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	IEmployeeService employeeService;

	@Mock
	List<EmployeeDto> employeeDtolist;
	@Mock 
	Employee employee;

	@Test
	void testAddEmployee() 
	{
		Mockito.when(employeeService.createEmployee(employeeDto)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.createemployee(employeeDto));
		Mockito.verify(employeeService).createEmployee(employeeDto);
	}


	@Test
	void updateEmployee() 
	{
		Mockito.when(employeeService.updateEmployee(empId,employeeDto)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.updateemployee(empId,employeeDto));
		Mockito.verify(employeeService).updateEmployee(empId,employeeDto);
	}
	

	@Test
	void deleteEmployee() 
	{
		Mockito.when(employeeService.deleteEmployee(12)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.deleteemployee(12));
		Mockito.verify(employeeService).deleteEmployee(12);

	}

	@Test
	void getEmployee() 
	{
		Mockito.when(employeeService.getEmployee(empId)).thenReturn(employeeDto);
		assertEquals(employeeDto,employeeController.getemployee(empId));
		Mockito.verify(employeeService).getEmployee(empId);
	}
	
	@Test
	void getAllEmployee() {
		Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeDtolist);
		assertEquals(employeeDtolist,employeeController.allemployees());
		Mockito.verify(employeeService).getAllEmployees();
	}


}