package kodlamaio.hrmsProject.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private int advertisementId;
	private String advertisementName;
	private String jobDescription;
	private int numberOfVacancies;
	private int jobSalary;
	private Date releaseDate;
	private Date applicationDate;
	private String companyName;
	private int sectorName;
	private int jobName;
	private int typeName;
	private int positionLevelName;
	private int educationLevelName;
	private int cityName;
	private int statuId;
}
