package kodlamaio.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name="firstname")
	private String firstname;
	
	@NotBlank
	@NotNull
	@Column(name="lastname")
	private String lastname;
	
	@NotBlank
	@NotNull
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@NotBlank
	@NotNull
	@Column(name="year_a_birth")
	private int date;
	
	@NotBlank
	@NotNull
	@Column(name="telephone")
	private String telephone;
	
	@Email
	@NotBlank
	@NotNull
	@Column(name="mail_address")
	private String email;
	
	@NotBlank
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotBlank
	@NotNull
	@Column(name="password_rep")
	private String password_rep;
	
	@Column(name="usertype")
	private int usertype;
	
	@Column(name="statu")
	private int statu;
	
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
