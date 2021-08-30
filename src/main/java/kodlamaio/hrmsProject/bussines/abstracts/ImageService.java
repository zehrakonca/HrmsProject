package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Image;

public interface ImageService {
	
	Result add (Image image,MultipartFile multipartFile);
	Result delete(int imageId);
	Result update (Image image);
	
	DataResult<Image> getByJobSeekerId(int jobSeekerId);
	
	DataResult<List<Image>> getAll();
}
