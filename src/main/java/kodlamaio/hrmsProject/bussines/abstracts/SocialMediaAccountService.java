package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccountService extends BaseEntitiyService<SocialMediaAccount>{
	DataResult<List<SocialMediaAccount>> getByJobSeekerId(int jobSeekerId);
}
