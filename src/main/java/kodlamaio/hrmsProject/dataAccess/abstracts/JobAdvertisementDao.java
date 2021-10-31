package kodlamaio.hrmsProject.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> getByIsActive(boolean isActive);
	
	List<JobAdvertisement> getByIsActive(boolean isActive,Sort sort);
	
	List<JobAdvertisement> getByIsActiveAndEmployerId(boolean isActive,int employerId,Sort sort);
	
//	@Query("From JobAdvertisement where statuId=1")
//	List<JobAdvertisement> getStatuIdIsTrue();
	
	@Query("From JobAdvertisement where employer.companyName=:companyName and isActive=:true")
	List<JobAdvertisement> getByCompanyNameAndActive(String companyName);
	
}
