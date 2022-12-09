package com.artefatox.example.parse;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.artefatox.example.dto.ProjectRequest;
import com.artefatox.example.dto.ProjectResponse;
import com.artefatox.example.entity.Project;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface ProjectMapper {

	@Mapping(source = "projectName", target = "name")
	@Mapping(source = "teamName", target = "team")
	Project toEntity(ProjectRequest request);
	
	@Mapping(source = "name", target = "projectName")
	@Mapping(source = "team", target = "teamName")
	@Mapping(source = "date", target = "creationDate")
	ProjectResponse toResponse(Project project);
}
