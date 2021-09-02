package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.EducationLevel;

public interface EducationLevelDao extends JpaRepository<EducationLevel, Integer> {

}
