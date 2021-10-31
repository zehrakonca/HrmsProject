package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.MilitaryStatuService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.MilitaryStatuDao;
import kodlamaio.hrmsProject.entities.concretes.MilitaryStatu;

@Service
public class MilitaryStatuManager implements MilitaryStatuService{
	private MilitaryStatuDao militaryStatuDao;

	@Autowired
	public MilitaryStatuManager(MilitaryStatuDao militaryStatuDao) {
		super();
		this.militaryStatuDao = militaryStatuDao;
	}

	@Override
	public Result add(MilitaryStatu militaryStatus) {
		this.militaryStatuDao.save(militaryStatus);
		return new SuccessResult("askerlik bilgisi eklendi.");
	}

	@Override
	public DataResult<List<MilitaryStatu>> getAll() {
		return new SuccessDataResult<List<MilitaryStatu>>(this.militaryStatuDao.findAll());				}

	@Override
	public Result update(MilitaryStatu entity) {
		this.militaryStatuDao.save(entity);
		return new SuccessResult("yıl bazlı deneyim bilgisi güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.militaryStatuDao.deleteById(id);
		return new SuccessResult("yıl bazlı deneyim bilgisi silindi.");
	}

	@Override
	public DataResult<MilitaryStatu> getById(int id) {
		return new SuccessDataResult<MilitaryStatu>(this.militaryStatuDao.getById(id), "data listelendi.");
}
}
