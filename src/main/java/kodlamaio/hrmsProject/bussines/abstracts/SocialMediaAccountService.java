package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccountService {
	Result add (SocialMediaAccount socialMediaAccount);

	Result update(SocialMediaAccount socialMediaAccount);

	Result delete(int accountId);
	
	DataResult<List<SocialMediaAccount>> getAll();
	
	DataResult<SocialMediaAccount> getById(int accountId);
	
	DataResult<List<SocialMediaAccount>> getByJobSeekerId(int jobSeekerId);
}
