package kodlamaio.hrmsProject.bussines.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisementConfirmation;

public interface JobAdvertisementConfirmationService extends BaseEntitiyService<JobAdvertisementConfirmation>{
	DataResult<JobAdvertisementConfirmation> getByAdvertisementId(int advertisementId);
}
