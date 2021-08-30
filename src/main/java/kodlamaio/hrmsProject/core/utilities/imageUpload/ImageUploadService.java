package kodlamaio.hrmsProject.core.utilities.imageUpload;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;

import java.util.Map;

public interface ImageUploadService {
	 @SuppressWarnings("rawtypes")
	 DataResult<Map> uploadImage(MultipartFile imageFile);
}
