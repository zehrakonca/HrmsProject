package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>> getAll();
	
	DataResult<List<Job>> getAll(int pageNo, int pageSize);
	
	DataResult<List<Job>> getAllSorted();
	
	Result add(Job job);
	
	Result update(Job job);
	
	Result delete(int jobId);
	
	DataResult<Job>getByJob(String jobName);
	
	DataResult<Job> getByJobNameAndSector(String jobName, int sectorId);
	 
	DataResult<List<Job>>getByJobNameOrSector(String jobName, int sectorId);
	
	DataResult<List<Job>> getBySectorIn(List<Integer> sectors);
	
	DataResult<List<Job>> getByJobNameContains(String jobName);// işin ismine göre arar.
	
	DataResult<List<Job>> getByJobNameStartsWith(String jobName); // girilen string ile başlıyorsa arar. 
	
	DataResult<List<Job>> getByNameAndSector(String jobName, int sectorId);
}
