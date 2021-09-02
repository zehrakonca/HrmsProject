package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.PositionLevel;

public interface PositionLevelDao  extends JpaRepository<PositionLevel, Integer> {

}
