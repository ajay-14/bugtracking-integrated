package com.bugtracking.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.bugtracking.dto.EmployeeDto;
import com.bugtracking.entities.Employee;
import com.bugtracking.mapper.EmployeeMapper;
import com.bugtracking.repository.IEmployeeRepository;
import com.bugtracking.services.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

	@Mock
	IEmployeeRepository er;

	@InjectMocks
	EmployeeServiceImpl esi;

	@Mock
	EmployeeDto employeeDto;

	@Mock
	Employee employee;

	@Mock
	List<EmployeeDto> employeeDtol;

	@Mock
	List<Employee> employeel;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		employeeDto.setEmpId(12l);
		employeeDto.setEmpContactNo("1234");
		employeeDto.setEmpEmail("ssls");
		employeeDto.setEmpName("ss");
		employeeDto.setProjectId(11l);
		
		EmployeeDto employeeDto=EmployeeMapper.toEmployeeDto(employee);
	}

	@Test
	void testbugById() {
		Mockito.when(er.findById(12l)).thenReturn(Optional.of(employee));
		EmployeeDto empDto1 = EmployeeMapper.toEmployeeDto(employee);
		assertEquals(empDto1.getEmpId(), esi.getEmployee(12l).getEmpId());
		Mockito.verify(er, times(1)).findById(12l);
	}

	@Test
	void testAddBug() {
		Mockito.when(er.save(any(Employee.class))).thenReturn(employee);
		EmployeeDto employeeDto1 = EmployeeMapper.toEmployeeDto(employee);
		EmployeeDto employeeDto2 = esi.createEmployee(employeeDto1);
		assertEquals(employeeDto2.getEmpId(), employeeDto2.getEmpId());
		Mockito.verify(er, atLeast(1)).save(any(Employee.class));
	}

	@Test
	void testupdateBug() {
		Mockito.when(er.existsById(12l)).thenReturn(true);
		Mockito.when(er.save(any(Employee.class))).thenReturn(employee);
		EmployeeDto employeeDto1 = EmployeeMapper.toEmployeeDto(employee);
		assertEquals(employee.getEmpId(),esi.updateEmployee(12l, employeeDto1).getEmpId());
		Mockito.verify(er, atLeast(1)).save(any(Employee.class));
	}

	@Test
	void testallbugs() {
		Mockito.when(er.findAll()).thenReturn(employeel);
		List<EmployeeDto> employeeDtol = EmployeeMapper.toEmployeeDtoList(employeel);
		assertEquals(employeeDtol, esi.getAllEmployees());
		Mockito.verify(er, times(1)).findAll();
	}


	@Test
	void testdeletebyid() {
		Mockito.when(er.existsById(12l)).thenReturn(true);
		Mockito.when(er.getById(12l)).thenReturn(employee);
		assertEquals(employee.getEmpId(), esi.deleteEmployee(12l).getEmpId());
		Mockito.verify(er, times(1)).existsById(12l);
	}

}
