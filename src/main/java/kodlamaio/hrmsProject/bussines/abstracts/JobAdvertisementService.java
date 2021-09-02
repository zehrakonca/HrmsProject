package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	Result add (JobAdvertisement jobAdvertisement);
	
	Result update(JobAdvertisement jobAdvertisement);

	Result delete(int advertisementId);
	
	Result updateStatu(int advertisementId);
	
	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
	DataResult<List<JobAdvertisement>> getStatuIdIsTrue();
	
	DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted();
	
	
}
