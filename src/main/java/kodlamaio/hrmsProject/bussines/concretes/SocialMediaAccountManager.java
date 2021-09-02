package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.SocialMediaAccountService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.SocialMediaAccountDao;
import kodlamaio.hrmsProject.entities.concretes.SocialMediaAccount;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService{

	private SocialMediaAccountDao socialMediaAccount;
	
	@Autowired
	public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccount) {
		super();
		this.socialMediaAccount = socialMediaAccount;
	}

	@Override
	public Result add(SocialMediaAccount socialMediaAccount) {
		this.socialMediaAccount.save(socialMediaAccount);
		return new SuccessResult("sosyal medya hesabı eklendi.");
	}
	
	@Override
	public Result update(SocialMediaAccount socialMediaAccount) {
		this.socialMediaAccount.save(socialMediaAccount);
		return new SuccessResult("sosyal medya hesabı güncellendi.");
	}

	@Override
	public Result delete(int accountId) {
		this.socialMediaAccount.deleteById(accountId);
		return new SuccessResult("sosyal medya hesabı silindi.");
	}

	@Override
	public DataResult<List<SocialMediaAccount>> getAll() {
		return new SuccessDataResult<List<SocialMediaAccount>>(this.socialMediaAccount.findAll());
	}

	@Override
	public DataResult<SocialMediaAccount> getById(int accountId) {
		return new SuccessDataResult<SocialMediaAccount>(this.socialMediaAccount.getById(accountId));
	}

	@Override
	public DataResult<List<SocialMediaAccount>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<SocialMediaAccount>>(this.socialMediaAccount.getByJobSeekerId(jobSeekerId));
	}

	

}
