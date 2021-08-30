package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.bussines.abstracts.ImageService;
import kodlamaio.hrmsProject.core.utilities.imageUpload.ImageUploadService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.ImageDao;
import kodlamaio.hrmsProject.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}


	private ImageDao imageDao;
	private ImageUploadService imageUploadService;
	
	@SuppressWarnings("unchecked")
	@Override
	public Result add(Image image, MultipartFile multipartFile) {
		
		Map<String, String> imageUpload = this.imageUploadService.uploadImage(multipartFile).getData();
		image.setUrl(imageUpload.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("resim başarıyla eklendi.");
	}

	@Override
	public DataResult<Image> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<Image>(this.imageDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
    }

	@Override
	public Result delete(int imageId) {
		this.imageDao.deleteById(imageId);
		return new SuccessResult("fotoğraf silindi.");
	}

	@Override
	public Result update(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("fotoğraf güncellendi.");
	}

}
