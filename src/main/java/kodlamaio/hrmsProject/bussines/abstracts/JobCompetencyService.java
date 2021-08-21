package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobCompetency;

public interface JobCompetencyService {
	Result add (JobCompetency jobCompetency);
	DataResult<List<JobCompetency>> getAll();
	DataResult<JobCompetency> getById(int competencyId);
	DataResult<List<JobCompetency>> getByJobSeekerId(int jobSeekerId);

}
