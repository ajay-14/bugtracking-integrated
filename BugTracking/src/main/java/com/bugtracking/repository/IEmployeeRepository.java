package com.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bugtracking.entities.Employee;

@Repository("er")
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
