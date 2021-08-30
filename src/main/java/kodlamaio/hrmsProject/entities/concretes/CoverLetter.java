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
@Table(name="cover_letters")
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="coverLetter_id")
	private int coverLetterId;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name="coverLetter_name")
	private String coverLetterName;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	
}
