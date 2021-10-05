package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.PositionLevelService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.PositionLevel;

@RestController
@RequestMapping("/api/positionLevels")
@CrossOrigin(origins = "http://localhost:3000")
public class PositionLevelsController {
	private PositionLevelService positionLevelService;

	@Autowired
	public PositionLevelsController(PositionLevelService positionLevelService) {
		super();
		this.positionLevelService = positionLevelService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody PositionLevel positionLevel)
	{
	return this.positionLevelService.add(positionLevel);
	}
	
	@GetMapping("getAll")
	public DataResult<List<PositionLevel>> getAll()
	{
		return this.positionLevelService.getAll();
		}
}