package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	
	//boolean emailCheck(String email);
	
	//boolean identityCheck(String identityNumber);
	
	JobSeeker findByEmail(String email);
	
	JobSeeker findByNationalIdentity(String identityNumber);
	
	JobSeeker getById(int jobSeekerId);
	
}
