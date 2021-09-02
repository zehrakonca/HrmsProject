package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Sector;

public interface SectorService {
	DataResult<List<Sector>> getAll();
	
	Result add(Sector sector);
	
	Result update(Sector sector);

	Result delete(int sectorId);
}
