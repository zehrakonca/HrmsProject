package kodlamaio.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	School getById(int id);
	List<School> getByJobSeekerId(int jobSeekerId);
}
