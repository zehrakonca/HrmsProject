package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.SchoolService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody School school)
	{
		return this.schoolService.add(school);
	}
	
	@GetMapping("getAll")
	public DataResult<List<School>> getAll()
	{
		return this.schoolService.getAll();
	}
	
	@GetMapping("getByJobSeekerId")
	public DataResult<List<School>> getByJobSeekerId(int jobSeekerId)
	{
		return this.schoolService.getByJobSeekerId(jobSeekerId);
	}
}
