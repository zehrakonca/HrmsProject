package kodlamaio.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="social_media_accounts")
@NoArgsConstructor
@AllArgsConstructor
public class SocialMediaAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="accountName")
	private String accountName;
	
	@Column(name="account_link")
	private String accountLink;
	
	@ManyToOne()
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
}
