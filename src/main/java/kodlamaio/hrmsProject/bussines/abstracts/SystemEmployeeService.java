package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.SystemEmployee;

public interface SystemEmployeeService{
	DataResult<List<SystemEmployee>> getAll();
	Result add(SystemEmployee systemEmployee);
	

	Result update(SystemEmployee systemEmployee);

	Result delete(int employeeId);
	
	Result updateMemberData(JobSeeker jobSeeker);
	
	Result updateEmployerData(Employer employer);
}
