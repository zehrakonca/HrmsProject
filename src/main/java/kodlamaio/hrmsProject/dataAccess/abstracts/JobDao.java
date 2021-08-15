package kodlamaio.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsProject.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	Job getByJobName(String jobName);
	
	Job getByJobNameAndSector_SectorId(String jobName, int sectorId);
	 
	List<Job>getByJobNameOrSector(String jobName, int sectorId);
	
	List<Job> getBySectorIn(List<Integer> sectors);
	
	List<Job> getByJobNameContains(String jobName);// işin ismine göre arar.
	
	List<Job> getByJobNameStartsWith(String jobName); // girilen string ile başlıyorsa arar. 
	
	@Query("From Job where jobName=:jobName and sector_id=:sectorId")
	List<Job> getByNameAndSector(String jobName, int sectorId);
	
}
