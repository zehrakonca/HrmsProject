package kodlamaio.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.bussines.abstracts.ImageService;
import kodlamaio.hrmsProject.bussines.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Image;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	private ImageService imageService;
	private JobSeekerService jobSeekerService;
	@Autowired
	public ImagesController(ImageService imageService, JobSeekerService jobSeekerService) {
		super();
		this.imageService = imageService;
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("add")
	public Result add (@RequestParam(value="jobSeekerId") int jobSeekerId, @RequestParam(value="imageFile") MultipartFile imageFile)
	{
		JobSeeker jobSeeker = this.jobSeekerService.getById(jobSeekerId).getData();
		Image image = new Image();
		image.setJobSeeker(jobSeeker);
		return this.imageService.add(image, imageFile);
	}
	
	@GetMapping("getAllImage")
	public DataResult<List<Image>> getAll()
	{
		return this.imageService.getAll();
	}
}
