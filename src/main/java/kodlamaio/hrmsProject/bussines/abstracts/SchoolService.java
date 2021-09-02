package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.School;

public interface SchoolService {
	Result add (School school);
	
	Result update(School school);

	Result delete(int schoolId);
	
	DataResult<School> getById(int schoolId);
	
	DataResult<List<School>>getByJobSeekerId(int jobSeekerId);
	
	DataResult<List<School>> getAll();

}
