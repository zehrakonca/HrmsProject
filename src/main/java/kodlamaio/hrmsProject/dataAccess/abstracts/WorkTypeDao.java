package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType,Integer> {

}
