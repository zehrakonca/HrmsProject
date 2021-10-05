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
import kodlamaio.hrmsProject.entities.concretes.MilitaryStatus;

@Service
public class MilitaryStatuManager implements MilitaryStatuService{
	private MilitaryStatuDao militaryStatuDao;

	@Autowired
	public MilitaryStatuManager(MilitaryStatuDao militaryStatuDao) {
		super();
		this.militaryStatuDao = militaryStatuDao;
	}

	@Override
	public Result add(MilitaryStatus militaryStatus) {
		this.militaryStatuDao.save(militaryStatus);
		return new SuccessResult("askerlik bilgisi eklendi.");
	}

	@Override
	public DataResult<List<MilitaryStatus>> getAll() {
		return new SuccessDataResult<List<MilitaryStatus>>(this.militaryStatuDao.findAll());				}
}
