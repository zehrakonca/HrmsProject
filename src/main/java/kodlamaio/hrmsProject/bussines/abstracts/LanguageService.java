package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Language;

public interface LanguageService {
	Result add (Language language);
	
	Result update(Language language);

	Result delete(int langugeId);
	
	DataResult<Language> getById(int languageId);
	
	DataResult<List<Language>> getByJobSeekerId(int jobSeekerId);
	
	DataResult<List<Language>> getAll();
	
}
