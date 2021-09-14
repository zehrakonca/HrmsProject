package kodlamaio.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrmsProject.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id", referencedColumnName ="id")
public class JobSeeker extends User{
	
	@NotBlank
	@NotNull
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@NotNull
	@Column(name="year_a_birth")
	private int date;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Image> images;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<SocialMediaAccount> socialMediaAccounts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobCompetency> jobCompetencies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CoverLetter> coverLetters;
}
