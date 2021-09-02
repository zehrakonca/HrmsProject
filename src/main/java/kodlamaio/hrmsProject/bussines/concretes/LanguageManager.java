package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.LanguageService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrmsProject.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("dil bilgisi eklendi.");
	}
	
	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("dil bilgisi güncellendi.");
	}

	@Override
	public Result delete(int langugeId) {
		this.languageDao.deleteById(langugeId);
		return new SuccessResult("dil bilgisi silindi.");
	}

	@Override
	public DataResult<Language> getById(int languageId) {
		return new SuccessDataResult<Language>(this.languageDao.getById(languageId));
	}

	@Override
	public DataResult<List<Language>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	

}
