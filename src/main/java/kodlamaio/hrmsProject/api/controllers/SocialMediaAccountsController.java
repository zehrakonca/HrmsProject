package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.SocialMediaAccountService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.SocialMediaAccount;

@RestController
@RequestMapping("/api/socialMediaAccounts")
public class SocialMediaAccountsController {
	private SocialMediaAccountService socialMediaAccountService;

	@Autowired
	public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
		super();
		this.socialMediaAccountService = socialMediaAccountService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody SocialMediaAccount socialMediaAccount)
	{
		return this.socialMediaAccountService.add(socialMediaAccount);
	}
	
	@GetMapping("getAllSocialMediaAccount")
	public DataResult<List<SocialMediaAccount>> getAllSocialMediaAccount()
	{
		return this.socialMediaAccountService.getAll();
	}
	
	@GetMapping("getAllSocialMediaAccountByJobSeekerId")
	public DataResult<List<SocialMediaAccount>> getAllSocialMediaAccountByJobSeekerId (@RequestParam int jobSeekerId)
	{
		return this.socialMediaAccountService.getByJobSeekerId(jobSeekerId);
	}
}
