package com.bugtracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.entities.Project;
import com.bugtracking.services.IProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
public class ProjectController {
	
	@Autowired
	IProjectService ps;
	
	@ApiOperation("Used to fetch all projects")
	@GetMapping("/projects")
	public List<Project> allprojects(){
		return ps.getall();		
	}
	@ApiOperation("Used to fetch project with particular id")
	@GetMapping("/projects/{projId}")
	public Project getproject(@PathVariable long projId) {
		return ps.getproject(projId);
	}
	@ApiOperation("Used to delete project with particular id")
	@DeleteMapping("/projects/{projId}")
	public Project deleteproject(@PathVariable long projId) {
		return ps.deleteproject(projId);
	}
	@ApiOperation("Used to create project")
	@PostMapping("/projects")
	public Project createproject(@RequestBody Project p){
		return ps.createproject(p);		
	}
	@ApiOperation("Used to update project")
	@PutMapping("/projects/{projId}")
	public Project updateproject(@PathVariable("projId")long projId,@Valid @RequestBody Project p){
		return ps.updateproject(projId,p);		
	}

}
