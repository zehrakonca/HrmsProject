package kodlamaio.hrmsProject.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrmsProject.bussines.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
//import kodlamaio.hrmsProject.entities.dtos.JobSeekerDto;
import kodlamaio.hrmsProject.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll()
	{
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
	}
	
	@GetMapping("getAllCv")
	public DataResult<List<CvDto>>getAllCv(@RequestParam int jobSeekerId)
	{
		return this.jobSeekerService.getAllCv();
	}
	
	@GetMapping("/getAllCvByJobSeekerId")
	public DataResult<List<CvDto>> getAllCvByJobSeekerId(@RequestParam(value = "jobseekerId")int jobseekerId){
		return this.jobSeekerService.getAllCvByJobSeekerId(jobseekerId);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions)
	{
		Map<String,String> validationErrors = new HashMap<String , String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}
