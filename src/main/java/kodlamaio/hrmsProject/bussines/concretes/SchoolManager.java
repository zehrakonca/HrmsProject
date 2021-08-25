package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.SchoolService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrmsProject.entities.concretes.School;

@Service
public class SchoolManager  implements SchoolService{

	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	private SchoolDao schoolDao;

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("okul bilgisi eklendi.");
	}

	@Override
	public DataResult<School> getById(int schoolId) {
		return new SuccessDataResult<School>(this.schoolDao.getById(schoolId));
	}

	@Override
	public DataResult<List<School>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getbByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}
	
	
}
