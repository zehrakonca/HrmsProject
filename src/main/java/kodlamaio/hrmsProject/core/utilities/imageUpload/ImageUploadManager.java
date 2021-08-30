package kodlamaio.hrmsProject.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService {

	private Cloudinary cloudinary; 
	
	public ImageUploadManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "myhrmsproject",
				"api_key", "369894462818311",
				"api_secret" , "j8t2lVSqPdoI1tMVZbMCRQFTfAs"
				));
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public DataResult<Map> uploadImage(MultipartFile imageFile) {
		try {
            Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<>(resultMap);

        }
        catch (IOException exception) {
            exception.printStackTrace();

        }
        return new ErrorDataResult<Map>();
	}

}
