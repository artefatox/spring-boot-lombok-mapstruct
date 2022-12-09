package com.artefatox.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artefatox.example.dto.ProjectRequest;
import com.artefatox.example.dto.ProjectResponse;
import com.artefatox.example.entity.Project;
import com.artefatox.example.parse.ProjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/example")
public class ExampleController {

	@Autowired
	private ProjectMapper mapper;
	
	@PostMapping
	public ProjectResponse endpoint(@RequestBody ProjectRequest request) {
		Project project = mapper.toEntity(request);
		project.setDate(LocalDate.now());
		log.info("Info {}", project);
		return mapper.toResponse(project);
	}
}
