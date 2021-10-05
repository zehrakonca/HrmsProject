package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.WorkTypeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/workTypes")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkTypeController {
	public WorkTypeService workTypeService;

	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<WorkType>> getAll()
	{
		return this.workTypeService.getAll();
	}
}
