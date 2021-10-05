package kodlamaio.hrmsProject.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="status")
@AllArgsConstructor
@NoArgsConstructor
public class Statu {
	
	@Id
	@Column(name="id")
	private int statuId;
	
	@Column(name="statu")
	private int statuName;
	

}
