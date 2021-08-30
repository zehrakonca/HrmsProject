package kodlamaio.hrmsProject.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int experienceId;
	
	@NotBlank
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
}
