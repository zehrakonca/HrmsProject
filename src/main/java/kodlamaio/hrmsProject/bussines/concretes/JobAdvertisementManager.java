package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setStatuId(1);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı eklendi.");
	}
	
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı bilgisi güncellendi.");
	}

	@Override
	public Result delete(int advertisementId) {
		this.jobAdvertisementDao.deleteById(advertisementId);
		return new SuccessResult("iş ilanı bilgisi silindi.");
	}

	@Override
	public Result updateStatu(int advertisementId) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(advertisementId);
		jobAdvertisement.setStatuId(2);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("iş ilanı güncellenmiştir.");
	}

	@Override
	public DataResult<List<JobAdvertisement>>getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCompanyNameAndActive(companyName));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getStatuIdIsTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getStatuIdIsTrue(),"data listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "applicationDate");
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByJobAdvertisementDetailsSorted(sort));
	}

	
}
