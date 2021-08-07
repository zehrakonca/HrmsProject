package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.SectorService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Sector;

@RestController
@RequestMapping("/api/sectors")
public class SectorsController {

	private SectorService sectorService;

	@Autowired
	public SectorsController(SectorService sectorService) {
		super();
		this.sectorService = sectorService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Sector>> getAll(){
		return this.sectorService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Sector sector)
	{
		return this.sectorService.add(sector);
	}
	
	
}
