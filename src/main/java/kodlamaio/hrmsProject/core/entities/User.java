package kodlamaio.hrmsProject.core.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrmsProject.entities.concretes.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@NotBlank
	@NotNull
	@Column(name="lastname")
	private String lastname;
	
	@NotBlank
	@NotNull
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	@Column(name="password_rep")
	private String password_rep;
	
	@Column(name="usertype")
	private int usertype;
	
	@Column(name="statu")
	private int statu;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user" )
	private List<Image> images;
}