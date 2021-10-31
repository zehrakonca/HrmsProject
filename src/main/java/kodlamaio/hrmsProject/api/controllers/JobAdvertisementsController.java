package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin(origins = "http://localhost:3000")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public  Result add (@RequestBody JobAdvertisement jobAdvertisement)
	{
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getDetailsSorted")
	public DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted()
	{
		return this.jobAdvertisementService.getJobAdvertisementDetailSorted();
	}
	
	@GetMapping("/getDetailsByCompanyName")
	public DataResult<List<JobAdvertisement>>getByCompanyName(@RequestParam String companyName)
	{
		return this.jobAdvertisementService.getByCompanyName(companyName);
	}
	
	@GetMapping("/getByStatuIdTrue")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam boolean isActive)
	{
		return jobAdvertisementService.getAllByIsActive(isActive);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll()
	{
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam("advertisementId") int advertisementId)
	{
		return jobAdvertisementService.getByAdvertisementId(advertisementId);
	}
	
	@PutMapping("/confirmAdvertisement")
	public Result confirm(@RequestParam int advertisementId,@RequestParam int systemEmployeeId,@RequestParam boolean isConfirmed)
	{
		return jobAdvertisementService.confirm(advertisementId, advertisementId, advertisementId, isConfirmed);
	}
	
	@PutMapping("/makeActiveOrPassive")
	public Result makeActiveOrPassive(@RequestParam int advertisementId,@RequestParam boolean isActive)
	{
		return jobAdvertisementService.makeActiveOrPassive(advertisementId, isActive);
	}
	
	@GetMapping("/getAllWaitingConfirmation")
	public DataResult<List<JobAdvertisement>>getAllWaitingConfirmation(){
		return jobAdvertisementService.getAllWaitingConfirmation();
	}	
}
