package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobCompetencyService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobCompetencyDao;
import kodlamaio.hrmsProject.entities.concretes.JobCompetency;

@Service
public class JobCompetencyManager implements JobCompetencyService {

	private JobCompetencyDao jobCompetencyDao;
	
	@Autowired
	public JobCompetencyManager(JobCompetencyDao jobCompetencyDao) {
		super();
		this.jobCompetencyDao = jobCompetencyDao;
	}

	@Override
	public Result add(JobCompetency jobCompetency) {
		this.jobCompetencyDao.save(jobCompetency);
		return new SuccessResult("yetkinlik alanı eklendi.");
	}
	
	@Override
	public Result update(JobCompetency jobCompetency) {
		this.jobCompetencyDao.save(jobCompetency);
		return new SuccessResult("yetkinlik alanı güncellendi.");
	}

	@Override
	public Result delete(int competencyId) {
		this.jobCompetencyDao.deleteById(competencyId);
		return new SuccessResult("yetkinlik alanı silindi.");
	}

	@Override
	public DataResult<List<JobCompetency>> getAll() {
		return new SuccessDataResult<List<JobCompetency>>(this.jobCompetencyDao.findAll());
	}

	@Override
	public DataResult<JobCompetency> getById(int competencyId) {
		return new SuccessDataResult<JobCompetency>(this.jobCompetencyDao.getById(competencyId));
	}

	@Override
	public DataResult<List<JobCompetency>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<JobCompetency>>(this.jobCompetencyDao.getByJobSeekerId(jobSeekerId));
	}

}
