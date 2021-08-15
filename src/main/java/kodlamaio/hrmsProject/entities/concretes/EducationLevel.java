package kodlamaio.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="education_levels")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
public class EducationLevel {
	@Id
	@Column(name="education_level_id")
	private int levelId;
	
	@Column(name="levelname")
	private String educationLevelName;
	
	@OneToMany(mappedBy = "educationLevel")
	private List<JobAdvertisement> jobAdvertisements;
}
