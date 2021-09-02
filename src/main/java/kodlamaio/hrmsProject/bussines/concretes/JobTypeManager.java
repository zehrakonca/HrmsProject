package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobTypeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobTypeDao;
import kodlamaio.hrmsProject.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService{
	
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	private JobTypeDao jobTypeDao;

	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll());
	}

	@Override
	public Result add(JobType jobType) {
		this.jobTypeDao.save(jobType);
		return new SuccessResult("iş tipi eklendi.");
	}

	@Override
	public Result update(JobType jobType) {
		this.jobTypeDao.save(jobType);
		return new SuccessResult("iş tipi güncellendi.");
	}

	@Override
	public Result delete(int typeId) {
		this.jobTypeDao.deleteById(typeId);
		return new SuccessResult("iş tipi silindi.");
	}
	
	
}
