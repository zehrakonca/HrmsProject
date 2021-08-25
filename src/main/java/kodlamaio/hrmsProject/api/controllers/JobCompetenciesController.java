package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrmsProject.bussines.abstracts.JobCompetencyService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobCompetency;

@RestController
@RequestMapping("/api/jobCompetencies")
public class JobCompetenciesController {
	private JobCompetencyService jobCompetencyService;

	@Autowired
	public JobCompetenciesController(JobCompetencyService jobCompetencyService) {
		super();
		this.jobCompetencyService = jobCompetencyService;
	}
	
	@PostMapping("add")
	public Result add (@RequestBody JobCompetency jobCompetency)
	{
		return this.jobCompetencyService.add(jobCompetency);
	}
	
	@GetMapping("getAllJobCompetencies")
	public DataResult<List<JobCompetency>> getAllJobCompetencies()
	{
		return this.jobCompetencyService.getAll();
	}
	
	@GetMapping("getJobCompetenciesByJobSeekerId")
	public DataResult<List<JobCompetency>> getJobCompetenciesByJobSeekerId(int jobSeekerId)
	{
		return this.jobCompetencyService.getByJobSeekerId(jobSeekerId);
	}
	
}
