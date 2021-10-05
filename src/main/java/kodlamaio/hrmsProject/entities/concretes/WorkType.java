package kodlamaio.hrmsProject.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="worktypes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
public class WorkType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="work_type_id")
	private int workTypeId;
	
	@Column(name="worktype_name")
	private String workTypeName;
	
	@OneToMany(mappedBy ="workType")
	private List<JobAdvertisement> jobAdvertisements;
	}
