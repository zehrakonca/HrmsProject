package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.SystemEmployee;

public interface SystemEmployeeDao  extends JpaRepository<SystemEmployee, Integer>{
	SystemEmployee findByEmail(String email);
}
