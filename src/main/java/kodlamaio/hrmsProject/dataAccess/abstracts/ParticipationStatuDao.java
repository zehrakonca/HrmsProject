package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.ParticipationStatus;

public interface ParticipationStatuDao extends JpaRepository<ParticipationStatus, Integer>{

}
