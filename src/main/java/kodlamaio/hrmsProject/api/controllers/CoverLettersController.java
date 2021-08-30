package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.CoverLetterService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverLetters")
public class CoverLettersController {
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("add")
	public Result add (@RequestBody CoverLetter coverLetter)
	{
		return this.coverLetterService.add(coverLetter);
	}
	
	@GetMapping("getAllCoverLetters")
	public DataResult<List<CoverLetter>> getAllCoverLetters()
	{
		return this.coverLetterService.getAll();
	}
	
	@GetMapping("getAllCoverLettersByJobSeekerId")
	public DataResult<CoverLetter> getAllCoverLettersByJobSeekerId(@RequestParam int jobSeekerId)
	{
		return this.coverLetterService.getByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("getById")
	public DataResult<CoverLetter> getById(@RequestParam int coverLetterId)
	{
		return this.coverLetterService.getById(coverLetterId);
	}
	
}
