package kodlamaio.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.JobCompetency;

public interface JobCompetencyDao extends JpaRepository<JobCompetency, Integer> {
	JobCompetency getById(int id);
	List<JobCompetency> getByJobSeekerId(int jobSeekerId);
}
