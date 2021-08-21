package kodlamaio.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.dtos.JobSeekerDto;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	
	//boolean emailCheck(String email);
	
	//boolean identityCheck(String identityNumber);
	
	JobSeeker findByEmail(String email);
	
	JobSeeker findByNationalIdentity(String identityNumber);
	
	JobSeeker findById(int jobSeekerId);
	
	@Query("Select new kodlamaio.hrmsProject.entities.dtos.JobSeekerDto"
			+ "(j.firstName, j.lastName, j.email,j.telephone, i.url from JobSeeker j Inner Join j.images i")
	List<JobSeekerDto> getDetail();
}
