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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="web_site_name")
	private String web_site_name;
	
	@Column(name="company_mail")
	private String companyMail;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="password")
	private String password;
	
	@Column(name="password_rep")
	private String password_rep;
	
	@Column(name="usertype")
	private int usertype;
	
	@Column(name="statu")
	private int statu;

}
