package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.MilitaryStatu;

public interface MilitaryStatuDao extends JpaRepository<MilitaryStatu, Integer>{

}
