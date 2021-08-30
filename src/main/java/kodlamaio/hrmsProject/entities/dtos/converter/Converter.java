package kodlamaio.hrmsProject.entities.dtos.converter;

import org.springframework.stereotype.Component;

import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.dtos.CvDto;

@Component
public class Converter {
	public CvDto convertToCv(JobSeeker jobSeeker)
	{
		return new CvDto(jobSeeker.getId(),
				         jobSeeker.getFirstname(),
				         jobSeeker.getLastname(),
				         jobSeeker.getDate(),
				         jobSeeker.getImages(),
				         jobSeeker.getEmail(),
				         jobSeeker.getTelephone(),
				         jobSeeker.getNationalIdentity(),
				         jobSeeker.getSchools(),
				         jobSeeker.getLanguages(),
				         jobSeeker.getJobExperiences(),
				         jobSeeker.getJobCompetencies(),
				         jobSeeker.getSocialMediaAccounts(),
				         jobSeeker.getCoverLetters());
	}
}
