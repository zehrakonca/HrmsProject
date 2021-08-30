package kodlamaio.hrmsProject.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{
	
	@Query("From CoverLetter where jobSeeker.id=:jobSeekerId")
	CoverLetter getByJobSeeker(int jobSeekerId);
	
	@Query("From CoverLetter where coverLetterId=:coverLetterId")
	CoverLetter getById(int coverLetterId);
	
	
}
