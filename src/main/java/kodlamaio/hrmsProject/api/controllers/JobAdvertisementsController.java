package kodlamaio.hrmsProject.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		jobAdvertisement.setReleaseDate(new Date());
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/updateStatu")
	public Result updateStatu(@RequestBody int advertisementId)
	{
		return this.jobAdvertisementService.updateStatu(advertisementId);
	}
	
//	@GetMapping("/getDetails")
//	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetail(int statu)
//	{
//		return this.jobAdvertisementService.getJobAdvertisementDetail(statu);
//	}
//	
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
	
	@GetMapping("/getByStatuId")
	public DataResult<List<JobAdvertisement>> getByStatuId()
	{
		return jobAdvertisementService.getStatuIdIsTrue();
	}
}
