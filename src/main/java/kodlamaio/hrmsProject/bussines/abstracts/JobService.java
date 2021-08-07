package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>> getAll();
	Result add(Job job);
}
