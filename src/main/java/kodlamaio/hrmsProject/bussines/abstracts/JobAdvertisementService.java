package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {
	Result add (JobAdvertisement jobAdvertisement);
	
	Result updateStatu(int advertisementId);
	
	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
	DataResult<List<JobAdvertisement>> getStatuIdIsTrue();
	
	DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted();
//	
//	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailSorted(int statu);
	
	
}
