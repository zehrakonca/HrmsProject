package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobType;

public interface JobTypeService {
	
	DataResult<List<JobType>> getAll();

	Result add(JobType jobType);

	Result update(JobType jobType);

	Result delete(int typeId);
}
