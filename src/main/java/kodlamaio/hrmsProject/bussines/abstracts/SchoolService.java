package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.School;

public interface SchoolService {
	Result add (School school);
	DataResult<School> getById(int schoolId);
	DataResult<List<School>>getByJobSeekerId(int jobSeekerId);
	

}
