package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.LanguageService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService)
	{
		super();
		this.languageService= languageService;
	}
	
	@PostMapping("add")
	public Result add (@RequestBody Language language)
	{
		return this.languageService.add(language);
	}
	
	@GetMapping("getAllLanguages")
	public DataResult<List<Language>> getAllLanguage()
	{
		return this.languageService.getAll();
	}
	
	@GetMapping("getAllLanguagesByJobSeekerId")
	public DataResult<List<Language>> getAllLanguagesByJobSeekerId(@RequestParam int jobSeekerId)
	{
		return this.languageService.getByJobSeekerId(jobSeekerId);
	}
}
