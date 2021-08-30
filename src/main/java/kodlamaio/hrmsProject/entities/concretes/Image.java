package kodlamaio.hrmsProject.entities.concretes;


import java.time.LocalDate;

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
@Table(name="images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name="image_url")
	private String url;
	
	@NotBlank
	@NotNull
	@Column(name="created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
}
