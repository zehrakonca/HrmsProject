package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.Language;

public interface LanguageService extends BaseEntitiyService<Language>{
	DataResult<List<Language>> getByJobSeekerId(int jobSeekerId);
	
}
