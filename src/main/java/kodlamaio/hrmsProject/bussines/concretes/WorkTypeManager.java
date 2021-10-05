package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.WorkTypeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrmsProject.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {
private WorkTypeDao workTypeDao;

@Autowired
public WorkTypeManager(WorkTypeDao workTypeDao) {
	super();
	this.workTypeDao = workTypeDao;
}

@Override
public Result add(WorkType workType) {
	this.workTypeDao.save(workType);
	return new SuccessResult("iş tip bilgisi eklendi");
}

@Override
public DataResult<List<WorkType>> getAll() {
	return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll());
}
}
