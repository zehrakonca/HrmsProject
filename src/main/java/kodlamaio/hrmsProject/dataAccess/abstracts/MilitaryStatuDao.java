package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.MilitaryStatus;

public interface MilitaryStatuDao extends JpaRepository<MilitaryStatus, Integer>{

}
