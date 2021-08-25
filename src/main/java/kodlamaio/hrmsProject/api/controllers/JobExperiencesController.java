package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.JobExperienceService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) 
	{
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobExperience jobExperience)
	{
		return this.jobExperienceService.add(jobExperience);
	}
	
	@GetMapping("getAllJobExperience")
	public DataResult<List<JobExperience>> getAllJobExperience()
	{
		return this.jobExperienceService.getAll();
	}
	
	 @GetMapping("/getByJobSeekerId")
	    public DataResult<List<JobExperience>> getByJobseekerId(@RequestParam int jobSeekerId)
	 {
	        return this.jobExperienceService.getByJobSeekerId(jobSeekerId);
	    }
}
