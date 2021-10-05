package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.MilitaryStatus;


public interface MilitaryStatuService {
	Result add(MilitaryStatus militaryStatus);
	DataResult<List<MilitaryStatus>> getAll();
}
