package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.EducationLevelService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EducationLevelDao;
import kodlamaio.hrmsProject.entities.concretes.EducationLevel;

@Service
public class EducationLevelManager implements EducationLevelService{

	@Autowired
	public EducationLevelManager(EducationLevelDao educationLevelDao) {
		super();
		this.educationLevelDao = educationLevelDao;
	}

	private EducationLevelDao educationLevelDao;
	
	@Override
	public Result add(EducationLevel educationLevel) {
		this.educationLevelDao.save(educationLevel);
		return new SuccessResult("eğitim seviyesi eklendi.");
	}

	@Override
	public Result update(EducationLevel educationLevel) {
		this.educationLevelDao.save(educationLevel);
		return new SuccessResult("eğitim seviyesi güncellendi.");
	}

	@Override
	public Result delete(int educationLevelId) {
		this.educationLevelDao.deleteById(educationLevelId);
		return new SuccessResult("eğitim seviyesi silindi.");
	}

	@Override
	public DataResult<List<EducationLevel>> getAll() {
		return new SuccessDataResult<List<EducationLevel>>(this.educationLevelDao.findAll(),"data listelendi.");
	}
	
}
