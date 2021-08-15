package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.JobService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;
	
	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}


	@GetMapping("/getAll")
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
		}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	
	@GetMapping("/getByJobName")
	public DataResult<Job> getByJobName(@RequestParam String jobName){
		return this.jobService.getByJob(jobName);
	}
	
	@GetMapping("/getByJobNameAndCategoryId")
	public DataResult<Job> getByJobNameAndSector(@RequestParam("jobName") String jobName,@RequestParam("sectorId") int sectorId)
	{
		return this.jobService.getByJobNameAndSector(jobName, sectorId);
	}
	
	@GetMapping("/getByJobNameContains")
	public DataResult<List<Job>> getByJobNameContains(@RequestParam String jobName)
	{
		return this.jobService.getByJobNameContains(jobName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Job>> getAll(@RequestParam int pageNo, int pageSize)
	{
		return this.jobService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllBySorted")
	public DataResult<List<Job>> getAllSorted()
	{
		return this.jobService.getAllSorted();
	}
	
	
}
