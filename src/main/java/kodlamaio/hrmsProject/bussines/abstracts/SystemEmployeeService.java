package kodlamaio.hrmsProject.bussines.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.SystemEmployee;

public interface SystemEmployeeService extends BaseEntitiyService<SystemEmployee>{
	
	Result updateMemberData(JobSeeker jobSeeker);
	
	Result updateEmployerData(Employer employer);
}
