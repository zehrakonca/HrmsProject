package kodlamaio.hrmsProject.bussines.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobAdvertisementConfirmationService;
import kodlamaio.hrmsProject.bussines.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.bussines.abstracts.SystemEmployeeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisementConfirmation;
import kodlamaio.hrmsProject.entities.concretes.SystemEmployee;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private SystemEmployeeService systemEmployeeService;
	private JobAdvertisementConfirmationService jobAdvertisementConfirmationService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setActive(false);
		jobAdvertisement.setReleaseDate(LocalDate.now());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement created.please waiting for confirm.");
	}
	
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("job advertisement updated.");
	}

	@Override
	public Result delete(int advertisementId) {
		this.jobAdvertisementDao.deleteById(advertisementId);
		return new SuccessResult("job advertisement deleted.");
	}

	@Override
	public DataResult<List<JobAdvertisement>>getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyNameAndActive(companyName));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"data listelendi.");
	}
	@Override
	public DataResult<JobAdvertisement> getByAdvertisementId(int advertisementId) {
		return new SuccessDataResult<JobAdvertisement>(jobAdvertisementDao.getById(advertisementId),"data listelendi.");
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveFalse(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActive(false),"data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByIsActive(true),"data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllWaitingConfirmation() {
		List<JobAdvertisement> result = new ArrayList<JobAdvertisement>();
		List<JobAdvertisement> passiveAdvertisement = getAllByIsActive(false).getData();
		
		for(JobAdvertisement jobAdvertisement:passiveAdvertisement)
		{
			if (jobAdvertisementConfirmationService.getByAdvertisementId(jobAdvertisement.getAdvertisementId()).getData() == null) {
				result.add(jobAdvertisement);	
				}
		}
		
		return new SuccessDataResult<List<JobAdvertisement>>(result);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "applicationDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(true, sort));
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id), "data listelendi.");
	}

	@Override
	public Result confirm(int advertisementId,int employerId, int systemEmployeeId, boolean isConfirmed) {
		JobAdvertisement jobAdvertisement = getById(advertisementId).getData();
		SystemEmployee systemEmployee = systemEmployeeService.getById(systemEmployeeId).getData();
		
		if(!isConfirmed) {
			delete(advertisementId);
			return new ErrorResult("job advertisement request has been rejected. ");
		}
		
		jobAdvertisement.setActive(true);
		jobAdvertisementDao.save(jobAdvertisement);
		jobAdvertisementConfirmationService.add(new JobAdvertisementConfirmation(jobAdvertisement,systemEmployee,isConfirmed));
		return new SuccessResult("job advertisement request has been accepted.");
	}

	@Override
	public Result makeActiveOrPassive(int advertisementId, boolean isActive) {
		String statu = isActive 
				? "job advertisement has been open." 
				: "job advertisement has been closed.";
		
		JobAdvertisement jobAdvertisement = getById(advertisementId).getData();
		jobAdvertisement.setActive(isActive);
		
		update(jobAdvertisement);
		return new SuccessResult(statu);
	}
}
