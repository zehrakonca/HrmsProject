package kodlamaio.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="status")

public class Statu {
	
	@Id
	@Column(name="id")
	private int statuId;
	
	@Column(name="statu")
	private int statuName;
	

}
