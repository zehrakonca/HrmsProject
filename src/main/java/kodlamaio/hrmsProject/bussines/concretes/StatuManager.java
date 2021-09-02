package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.StatuDao;
import kodlamaio.hrmsProject.entities.concretes.Statu;
import kodlamaio.hrmsProject.bussines.abstracts.StatuService;

@Service
public class StatuManager implements StatuService{

	@Autowired
	public StatuManager(StatuDao statuDao) {
		super();
		this.statuDao = statuDao;
	}

	private StatuDao statuDao;
	@Override
	public DataResult<List<Statu>> getAll() {
		return new SuccessDataResult<List<Statu>>(this.statuDao.findAll());
	}

	@Override
	public Result add(Statu statu) {
		this.statuDao.save(statu);
		return new SuccessResult("Statu bilgisi eklendi.");
	}

	@Override
	public Result update(Statu statu) {
		this.statuDao.save(statu);
		return new SuccessResult("Statu bilgisi güncellendi.");
	}

	@Override
	public Result delete(int statuId) {
		this.statuDao.deleteById(statuId);
		return new SuccessResult("statu bilgisi silindi.");
	}

}
