package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobDao;
import kodlamaio.hrmsProject.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "data listelendi.");
	}

	@Override
	public Result add(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("iş bilgisi eklendi.");
	}
	
	@Override
	public Result update(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("iş bilgisi güncellendi.");
	}

	@Override
	public Result delete(int jobId) {
		this.jobDao.deleteById(jobId);
		return new SuccessResult("iş bilgisi silindi.");

	}

	@Override
	public DataResult<Job> getByJob(String jobName) {
		return new SuccessDataResult<Job>(this.jobDao.getByJobName(jobName), "data listelendi.");
	}

	@Override
	public DataResult<Job> getByJobNameAndSector(String jobName, int sectorId) {
		return new SuccessDataResult<Job>(this.jobDao.getByJobNameAndSector_SectorId(jobName,sectorId), "data listelendi.");
	}

	@Override
	public DataResult<List<Job>> getByJobNameOrSector(String jobName, int sectorId) {
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByJobNameOrSector(jobName, sectorId));		
	}

	@Override
	public DataResult<List<Job>> getBySectorIn(List<Integer> sectors) {
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getBySectorIn(sectors));	
	}

	@Override
	public DataResult<List<Job>> getByJobNameContains(String jobName) {
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByJobNameContains(jobName));	
	}

	@Override
	public DataResult<List<Job>> getByJobNameStartsWith(String jobName) {
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByJobNameStartsWith(jobName));	
	}

	@Override
	public DataResult<List<Job>> getByNameAndSector(String jobName, int sectorId) {
		return new SuccessDataResult<List<Job>>
		(this.jobDao.getByNameAndSector(jobName, sectorId));	
	}

	@Override
	public DataResult<List<Job>> getAll(int pageNo, int pageSize) {
		Pageable pegeable = PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(pegeable).getContent());
	}

	@Override
	public DataResult<List<Job>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC,"jobName");
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(sort),"başarılı.");
	}

	

}
