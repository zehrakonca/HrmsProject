package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.SystemEmployeeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/system_employee")
public class SystemEmployeesController {
	
	private SystemEmployeeService systemEmployeeService;

	@Autowired
	public SystemEmployeesController(SystemEmployeeService systemEmployeeService) {
		super();
		this.systemEmployeeService = systemEmployeeService;
	}
	@GetMapping("/getAll")
	public DataResult<List<SystemEmployee>> getAll(){
		return this.systemEmployeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployee systemEmployee)
	{
		return this.systemEmployeeService.add(systemEmployee);
	}
	
	@PostMapping("/updateEmployer")
	public Result updateEmployer(@RequestBody Employer employer)
	{
		return this.systemEmployeeService.updateEmployerData(employer);
	}
	
	@PostMapping("updateJobSeeker")
	public Result updateJobSeeker (@RequestBody JobSeeker jobSeeker) {
		return this.systemEmployeeService.updateMemberData(jobSeeker);
	}

}
