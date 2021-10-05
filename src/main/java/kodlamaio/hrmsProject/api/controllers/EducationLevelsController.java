package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.EducationLevelService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.EducationLevel;

@RestController
@RequestMapping("/api/educationLevels")
@CrossOrigin(origins = "http://localhost:3000")
public class EducationLevelsController {
	private EducationLevelService educationLevelService;

	@Autowired
	public EducationLevelsController(EducationLevelService educationLevelService) {
		super();
		this.educationLevelService = educationLevelService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody EducationLevel educationLevel)
	{
	return this.educationLevelService.add(educationLevel);
	}
	
	@GetMapping("getAll")
	public DataResult<List<EducationLevel>> getAll()
	{
		return this.educationLevelService.getAll();
		}
}