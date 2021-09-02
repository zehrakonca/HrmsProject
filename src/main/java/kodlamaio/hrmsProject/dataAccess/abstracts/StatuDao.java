package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.Statu;

public interface StatuDao extends JpaRepository<Statu, Integer>{

}
