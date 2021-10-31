package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.School;

public interface SchoolService extends BaseEntitiyService<School>{
	DataResult<List<School>>getByJobSeekerId(int jobSeekerId);

}
