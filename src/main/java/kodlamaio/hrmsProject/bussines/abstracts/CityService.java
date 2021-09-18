package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}
