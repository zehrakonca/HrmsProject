package kodlamaio.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="system_employee")
@AllArgsConstructor
@NoArgsConstructor
public class SystemEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="national_identiy")
	private String national_identity;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="mail_address")
	private String email;
	
	@Column(name="user_type")
	private int usertype;
	
	@Column(name="job")
	private int job;
	
}
