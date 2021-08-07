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
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="year_a_birth")
	private int date;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="mail_address")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="password_rep")
	private String password_rep;
	
	@Column(name="usertype")
	private int usertype;
	
	@Column(name="statu")
	private int statu;
	
}
