package com.artefatox.example.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Project {

	private String name;
	private LocalDate date;
	private String team;
}
