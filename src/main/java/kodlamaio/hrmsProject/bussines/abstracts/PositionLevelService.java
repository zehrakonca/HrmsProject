package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.PositionLevel;

public interface PositionLevelService  {
	DataResult<List<PositionLevel>> getAll();

	Result add(PositionLevel positionLevel);

	Result update(PositionLevel positionLevel);

	Result delete(int positionLevelId);
}
