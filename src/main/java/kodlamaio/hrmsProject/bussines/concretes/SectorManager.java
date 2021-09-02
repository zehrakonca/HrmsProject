package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.SectorService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.SectorDao;
import kodlamaio.hrmsProject.entities.concretes.Sector;

@Service
public class SectorManager implements SectorService {
	
	private SectorDao sectorDao;
	
	@Autowired
	public SectorManager(SectorDao sectorDao) {
		super();
		this.sectorDao = sectorDao;
	}

	@Override
	public DataResult<List<Sector>> getAll() {
		return new SuccessDataResult<List<Sector>>(this.sectorDao.findAll(), "sektörler listelendi.");
	}

	@Override
	public Result add(Sector sector) {
		this.sectorDao.save(sector);
		return new SuccessResult("sektör bilgisi eklendi");
	}

	@Override
	public Result update(Sector sector) {
		this.sectorDao.save(sector);
		return new SuccessResult("sektör bilgisi güncellendi");
	}

	@Override
	public Result delete(int sectorId) {
		this.sectorDao.deleteById(sectorId);
		return new SuccessResult("sektör bilgisi silindi.");
	}
	
}
