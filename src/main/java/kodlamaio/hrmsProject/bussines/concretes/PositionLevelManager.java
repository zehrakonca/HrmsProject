package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.PositionLevelService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.PositionLevelDao;
import kodlamaio.hrmsProject.entities.concretes.PositionLevel;

@Service
public class PositionLevelManager implements PositionLevelService{
	@Autowired
	public PositionLevelManager(PositionLevelDao positionLevelDao) {
		super();
		this.positionLevelDao = positionLevelDao;
	}

	private PositionLevelDao positionLevelDao;

	@Override
	public DataResult<List<PositionLevel>> getAll() {
		return new SuccessDataResult<List<PositionLevel>>(this.positionLevelDao.findAll());
	}

	@Override
	public Result add(PositionLevel positionLevel) {
		this.positionLevelDao.save(positionLevel);
		return new SuccessResult("İş pozisyon derecesi eklendi.");
	}

	@Override
	public Result update(PositionLevel positionLevel) {
		this.positionLevelDao.save(positionLevel);
		return new SuccessResult("İş pozisyon derecesi güncellendi.");
	}

	@Override
	public Result delete(int positionLevelId) {
		this.positionLevelDao.deleteById(positionLevelId);
		return new SuccessResult("İş pozisyon derecesi silindi.");
	}
	
	
}
