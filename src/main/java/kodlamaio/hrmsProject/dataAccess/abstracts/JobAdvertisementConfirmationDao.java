package kodlamaio.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrmsProject.entities.concretes.JobAdvertisementConfirmation;

public interface JobAdvertisementConfirmationDao extends JpaRepository<JobAdvertisementConfirmation, Integer> {
	JobAdvertisementConfirmation getByJobAdvertisement(int advertisementId);
}
