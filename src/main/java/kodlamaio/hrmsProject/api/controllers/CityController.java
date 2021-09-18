package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.CityService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "http://localhost:3000")
public class CityController {
	
	public CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<City>> getAll()
	{
		return this.cityService.getAll();
	}
}
