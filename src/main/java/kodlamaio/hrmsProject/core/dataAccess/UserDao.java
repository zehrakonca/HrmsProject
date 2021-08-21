package kodlamaio.hrmsProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
		User findByEmail(String email);
}
