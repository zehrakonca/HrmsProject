package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;

public interface BaseEntitiyService<T> {
	Result add(T entity);
	Result update (T entity);
	Result delete (int id);
	DataResult<List<T>> getAll();
	DataResult<T> getById(int id);
}
