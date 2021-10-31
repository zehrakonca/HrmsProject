package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.dtos.CvDto;

public interface JobSeekerService extends BaseEntitiyService<JobSeeker>{
	
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
	
	DataResult<JobSeeker> getByEmail(String email);
	
	DataResult<List<CvDto>> getAllCvByJobSeekerId(int jobSeekerId);
	
	DataResult<List<CvDto>> getAllCv();
}
