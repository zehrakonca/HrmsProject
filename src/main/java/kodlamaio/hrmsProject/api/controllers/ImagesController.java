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
import kodlamaio.hrmsProject.core.entities.User;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Image;

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
	public Result add (@RequestParam(value="userId") int userId, @RequestParam(value="imageFile") MultipartFile imageFile)
	{
		User user = this.jobSeekerService.getById(userId).getData();
		Image image = new Image();
		image.setUser(user);
		return this.imageService.add(image, imageFile);
	}
	
	@GetMapping("getAllImage")
	public DataResult<List<Image>> getAll()
	{
		return this.imageService.getAll();
	}
	
	@GetMapping("getAllImageById")
	public DataResult<Image>getAllImageById(@RequestParam(value="userId") int userId){
		return this.imageService.getByUserId(userId);
	}
}
