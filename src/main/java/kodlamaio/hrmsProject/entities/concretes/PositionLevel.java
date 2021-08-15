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
@Table(name ="position_levels")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
public class PositionLevel {
	@Id
	@Column(name="position_level_id")
	private int levelId;
	
	@Column(name="levelname")
	private String positionlevelName;
	
	@OneToMany(mappedBy = "positionLevel")
	private List<JobAdvertisement> jobAdvertisements;
}
