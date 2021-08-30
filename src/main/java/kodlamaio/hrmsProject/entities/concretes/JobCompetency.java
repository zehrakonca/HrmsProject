package kodlamaio.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_competencies")
@AllArgsConstructor
@NoArgsConstructor
public class JobCompetency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="competency_id")
	private int competencyId;
	
	@Column(name="competency_name")
	private String competencyName;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
}
