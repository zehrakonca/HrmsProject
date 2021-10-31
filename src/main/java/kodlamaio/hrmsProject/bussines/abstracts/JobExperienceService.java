package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;

public interface JobExperienceService extends BaseEntitiyService<JobExperience> {
	DataResult<List<JobExperience>> getByJobSeekerId(int jobSeekerId);
}
