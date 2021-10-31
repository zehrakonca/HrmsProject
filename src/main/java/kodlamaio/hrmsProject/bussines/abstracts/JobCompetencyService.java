package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobCompetency;

public interface JobCompetencyService extends BaseEntitiyService<JobCompetency>{
	DataResult<List<JobCompetency>> getByJobSeekerId(int jobSeekerId);

}
