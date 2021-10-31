package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService extends BaseEntitiyService<JobAdvertisement>{
	
	Result confirm(int advertisementId,int employerId, int systemEmployeeId, boolean isConfirmed);
	
	Result makeActiveOrPassive(int advertisementId, boolean isActive);
	
	DataResult<List<JobAdvertisement>> getByCompanyName(String companyName);
	
	DataResult<List<JobAdvertisement>> getAllByIsActive(boolean isActive);

	DataResult<List<JobAdvertisement>> getAllByIsActiveFalse(boolean isActive);
	
	DataResult<List<JobAdvertisement>> getJobAdvertisementDetailSorted();
	
	DataResult<List<JobAdvertisement>> getAllWaitingConfirmation();
	
	DataResult<JobAdvertisement> getByAdvertisementId(int advertisementId);
	
	
}
