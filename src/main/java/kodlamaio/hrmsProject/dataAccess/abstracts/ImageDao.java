package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	Image getById(int id);
	Image getByJobSeekerId(int jobSeekerId);
}
