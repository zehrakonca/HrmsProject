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

@Entity
@Data
@Table(name="schools")
@AllArgsConstructor
@NoArgsConstructor
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	@NotBlank
	@NotNull
	@Column(name="school_name")
	private String schoolName;
	
	@NotBlank
	@NotNull
	@Column(name="school_department")
	private String schoolDepartment;
	
	@NotBlank
	@NotNull
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="graduation_date")
	private Date graduationYear;
	
	@NotBlank
	@NotNull
	@ManyToOne()
	@JoinColumn(name="statu_id")
	private ParticipationStatus participationStatus;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;	
}
