package kodlamaio.hrmsProject.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerDto {
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String url;
	

}
