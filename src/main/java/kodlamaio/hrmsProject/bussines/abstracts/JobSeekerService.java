package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.dtos.CvDto;
import kodlamaio.hrmsProject.entities.dtos.JobSeekerDto;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	
	Result add(JobSeeker jobSeeker);
	
	DataResult<JobSeeker> getById(int jobSeekerId);
	
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);
	
	DataResult<JobSeeker> getByEmail(String email);
	
	DataResult<List<JobSeekerDto>> getJobSeekerDto();
	
	DataResult<CvDto> getJobSeekerCv(int jobSeekerId);
}
