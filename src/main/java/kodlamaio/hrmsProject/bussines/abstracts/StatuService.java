package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Statu;


public interface StatuService {

	DataResult<List<Statu>> getAll();

	Result add(Statu statu);

	Result update(Statu statu);

	Result delete(int statuId);
}
