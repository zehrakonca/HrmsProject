package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add (JobExperience jobExperience);
	
	Result update(JobExperience jobExperience);

	Result delete(int experienceId);
	
	DataResult<List<JobExperience>> getAll();
	
	DataResult<List<JobExperience>> getByJobSeekerId(int jobSeekerId);
	
	DataResult<JobExperience> getById(int experienceId);
}
