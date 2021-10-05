package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.WorkType;

public interface WorkTypeService {
	Result add(WorkType workType);
	DataResult<List<WorkType>> getAll();
}
