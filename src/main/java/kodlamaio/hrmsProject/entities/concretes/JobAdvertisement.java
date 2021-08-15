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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advertisement_id")
	private int advertisementId;
	
	@Column(name="advertisement_name")
	private String advertisementName;
	
	@Column(name="sector_id")
	private int sectorId;
	
	@ManyToOne
	@JoinColumn(name="position_level_id")
	private PositionLevel positionLevel;
	
	@ManyToOne
	@JoinColumn(name="education_level_id")
	private EducationLevel educationLevel;
	
	@Column(name="number_of_vacancies")
	private int numberOfVacancies;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="job_salary")
	private int jobSalary;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name="release_date")
	private Date releaseDate;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name="application_date")
	private Date applicationDate;
	
	@Column(name="statu_id")
	private int statuId;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
		
	@ManyToOne	
	@JoinColumn(name="job_id")
	private Job job;

	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private JobType jobType;
	
}
