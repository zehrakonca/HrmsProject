package kodlamaio.hrmsProject.entities.dtos;

import java.util.List;

import kodlamaio.hrmsProject.entities.concretes.CoverLetter;
import kodlamaio.hrmsProject.entities.concretes.Image;
import kodlamaio.hrmsProject.entities.concretes.JobCompetency;
import kodlamaio.hrmsProject.entities.concretes.JobExperience;
import kodlamaio.hrmsProject.entities.concretes.Language;
import kodlamaio.hrmsProject.entities.concretes.School;
import kodlamaio.hrmsProject.entities.concretes.SocialMediaAccount;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CvDto {
	
	public CvDto(int jobSeekerId, String firstName, String lastName, int birthDate, List<Image> images, String email, String telephone, String nationalIdentity, List<School> schools, List<Language> languages, List<JobExperience> jobExperiences, List<JobCompetency> jobCompetencies, List<SocialMediaAccount> socialMediaAccounts, List<CoverLetter> coverLetters) {
		super();
		this.jobSeekerId = jobSeekerId;
		this.images = images;
		this.email= email;
		this.telephone = telephone;
		this.nationalIdentity = nationalIdentity;
		this.schools = schools;
		this.languages = languages;
		this.jobExperiences = jobExperiences;
		this.jobCompetencies= jobCompetencies;
		this.socialMediaAccounts = socialMediaAccounts;
		this.coverLetters = coverLetters;
	}
	
	int jobSeekerId;
	String email;
	String telephone;
	String nationalIdentity;
	CoverLetter coverLetter;
	List<Image> images;
	List<School> schools;
	List<JobExperience> jobExperiences;
	List<Language> languages;
	List<SocialMediaAccount> socialMediaAccounts;
	List<JobCompetency> jobCompetencies;
	List<CoverLetter> coverLetters;
}
