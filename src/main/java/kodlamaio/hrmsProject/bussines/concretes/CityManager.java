package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.CityService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CityDao;
import kodlamaio.hrmsProject.entities.concretes.City;

@Service
public class CityManager implements CityService{

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}
	public CityDao cityDao;
	
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(),"data listelendi");
				}
	

}
