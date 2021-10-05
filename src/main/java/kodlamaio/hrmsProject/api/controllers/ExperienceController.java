package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.ExperienceService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController {
public ExperienceService experienceService;

public ExperienceController(ExperienceService experienceService) {
	super();
	this.experienceService = experienceService;
}
@GetMapping("getAll")
public DataResult<List<Experience>> getAll()
{
	return this.experienceService.getAll();
}
}
