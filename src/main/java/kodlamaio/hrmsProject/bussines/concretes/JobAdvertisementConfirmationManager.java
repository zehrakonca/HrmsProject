package kodlamaio.hrmsProject.bussines.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobAdvertisementConfirmationService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementConfirmationDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisementConfirmation;

@Service
public class JobAdvertisementConfirmationManager implements JobAdvertisementConfirmationService{
	
	private JobAdvertisementConfirmationDao jobAdvertisementConfirmationDao;
	

	@Autowired
	public JobAdvertisementConfirmationManager(
			JobAdvertisementConfirmationDao jobAdvertisementConfirmationDao) {
		super();
		this.jobAdvertisementConfirmationDao = jobAdvertisementConfirmationDao;
	}

	@Override
	public Result add(JobAdvertisementConfirmation jobAdvertisementConfirmation) {
		jobAdvertisementConfirmation.setIsConfirmedDate(LocalDate.now());
		jobAdvertisementConfirmationDao.save(jobAdvertisementConfirmation);
		return new SuccessResult();
	}

	@Override
	public Result update(JobAdvertisementConfirmation jobAdvertisementConfirmation) {
		jobAdvertisementConfirmationDao.save(jobAdvertisementConfirmation);
		return new SuccessResult();
		}

	@Override
	public Result delete(int id) {
		jobAdvertisementConfirmationDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvertisementConfirmation>> getAll() {
		return new SuccessDataResult<List<JobAdvertisementConfirmation>>(jobAdvertisementConfirmationDao.findAll());
	}

	@Override
	public DataResult<JobAdvertisementConfirmation> getById(int id) {
		return new SuccessDataResult<JobAdvertisementConfirmation>(jobAdvertisementConfirmationDao.getById(id));
	}

	@Override
	public DataResult<JobAdvertisementConfirmation> getByAdvertisementId(int advertisementId) {
		return new SuccessDataResult<JobAdvertisementConfirmation>(jobAdvertisementConfirmationDao.getByJobAdvertisement(advertisementId));
	}

}
