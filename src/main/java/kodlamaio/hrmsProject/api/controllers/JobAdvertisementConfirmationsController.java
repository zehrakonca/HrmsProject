package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.JobAdvertisementConfirmationService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisementConfirmation;

@RestController
@RequestMapping("/api/jobAdvertisementConfirmations")
@CrossOrigin(origins = "http://localhost:3000")
public class JobAdvertisementConfirmationsController {

	private JobAdvertisementConfirmationService jobAdvertisementConfirmationService;

	@Autowired
	public JobAdvertisementConfirmationsController(
			JobAdvertisementConfirmationService jobAdvertisementConfirmationService) {
		super();
		this.jobAdvertisementConfirmationService = jobAdvertisementConfirmationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisementConfirmation>> getAll(){
		return jobAdvertisementConfirmationService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvertisementConfirmation> getByIdDataResult(@RequestParam int id){
		return jobAdvertisementConfirmationService.getById(id);
	}
	
	@GetMapping("/getByJobAdvertisementId")
	public DataResult<JobAdvertisementConfirmation> getByAdvertisementId(@RequestParam int advertisementId)
	{
		return jobAdvertisementConfirmationService.getByAdvertisementId(advertisementId);
	}

}
