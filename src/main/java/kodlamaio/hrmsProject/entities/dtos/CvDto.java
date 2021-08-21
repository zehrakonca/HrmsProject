package kodlamaio.hrmsProject.entities.dtos;

import java.util.List;

import kodlamaio.hrmsProject.entities.concretes.CoverLetter;
import kodlamaio.hrmsProject.entities.concretes.Image;
import kodlamaio.hrmsProject.entities.concretes.JobCompetency;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.Language;
import kodlamaio.hrmsProject.entities.concretes.School;
import kodlamaio.hrmsProject.entities.concretes.SocialMediaAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	private JobSeeker jobSeeker;
	private CoverLetter coverLetter;
	private Image image;
	private List<School> schools;
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private List<SocialMediaAccount> socialMediaAccounts;
	private List<JobCompetency> jobCompetencies;
}
