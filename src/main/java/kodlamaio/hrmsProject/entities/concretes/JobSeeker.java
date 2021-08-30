package kodlamaio.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.PrimaryKeyJoinColumn;
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
//@PrimaryKeyJoinColumn(name="id", referencedColumnName ="id")
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_seeker_id")
	private int id;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="firstname")
	private String firstname;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="lastname")
	private String lastname;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="year_a_birth")
	private int date;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="telephone")
	private String telephone;
	
	@Email
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="mail_address")
	private String email;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name="password_rep")
	private String password_rep;
	
	@JsonIgnore
	@Column(name="usertype")
	private int usertype;
	
	@JsonIgnore
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
