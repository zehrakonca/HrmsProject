package kodlamaio.hrmsProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	Image getByImageId(int imageId);
	Image getUrlByUser_Id(int userId);
}
