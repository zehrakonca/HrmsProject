package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.JobTypeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobTypes")
@CrossOrigin(origins = "http://localhost:3000")
public class JobTypesController {
	private JobTypeService jobTypeService;

	@Autowired
	public JobTypesController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobType>> getAll(){
		return this.jobTypeService.getAll();
		}
	
	}
