package kodlamaio.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="job_advertisement_confirmations")
public class JobAdvertisementConfirmation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="confirmation_id")
	private int confirmationId;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="is_confirmed_date")
	private LocalDate isConfirmedDate;
	
	@ManyToOne()
	@JoinColumn(name="advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@ManyToOne()
	@JoinColumn(name="system_employee_id")
	private SystemEmployee systemEmployee;
	
	public JobAdvertisementConfirmation(JobAdvertisement jobAdvertisement, SystemEmployee systemEmployee, boolean isConfirmed)
	{
		this.setJobAdvertisement(jobAdvertisement);
		this.setSystemEmployee(systemEmployee);
		this.setConfirmed(isConfirmed);
	}
	
}
