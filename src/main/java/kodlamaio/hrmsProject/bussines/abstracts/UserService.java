package kodlamaio.hrmsProject.bussines.abstracts;


import kodlamaio.hrmsProject.core.entities.User;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;


public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
