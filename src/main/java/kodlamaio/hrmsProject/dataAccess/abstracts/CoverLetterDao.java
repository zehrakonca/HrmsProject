package kodlamaio.hrmsProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{
	CoverLetter getById(int id);
	CoverLetter getByJobSeekerId(int jobSeekerId);
}
