package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.EducationLevel;

public interface EducationLevelService {
	
	Result add(EducationLevel educationLevel);
	Result update(EducationLevel educationLevel);
	Result delete (int educationLevelId);
	
	DataResult<List<EducationLevel>> getAll();
}
