package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.MilitaryStatuService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.MilitaryStatus;

@RestController
@RequestMapping("/api/militaryStatus")
@CrossOrigin(origins = "http://localhost:3000")
public class MilitaryStatuController {
	public MilitaryStatuService militaryStatuService;

	@Autowired
	public MilitaryStatuController(MilitaryStatuService militaryStatuService) {
		super();
		this.militaryStatuService = militaryStatuService;
	}
	@GetMapping("getAll")
	public DataResult<List<MilitaryStatus>> getAll()
	{
		return this.militaryStatuService.getAll();
		}
	
	}