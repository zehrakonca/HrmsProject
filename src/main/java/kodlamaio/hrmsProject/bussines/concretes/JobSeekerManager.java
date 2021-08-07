package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
//import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.validations.concretes.MailValidation;
//import kodlamaio.hrmsProject.core.validations.abstracts.IdentityValidationService;
//import kodlamaio.hrmsProject.core.validations.abstracts.MailValidationService;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	//private MailValidationService mailValidationService;
	//private IdentityValidationService identityValidationService;
	/*@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MailValidationService mailValidationService, IdentityValidationService identityValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.identityValidationService = identityValidationService;
		this.mailValidationService = mailValidationService;
	}*/
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"iş arayan kişiler listelendi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
			if (!dataControl(jobSeeker)) {
				return new ErrorResult("Kayıt için eksik değer girildi, kontrol edip tekrar deneyin.");
			}
			if (!MailValidation.checkEmail(jobSeeker.getEmail())) {
				return new ErrorResult("Email hatalı."+ jobSeeker.getEmail());
			}
			//if (employerDao.findBycompanyMail(employer.getCompanyMail())!=null)
			
			if (jobSeekerDao.findByEmail(jobSeeker.getEmail())!=null){
				return new ErrorResult("E-Posta adresiniz sistemde kayıtlıdır.");
			}
			if (jobSeekerDao.findByNationalIdentity(jobSeeker.getNationalIdentity())!=null) {
				return new ErrorResult("Kimlik numaranız sistemde kayıtlıdır.");
			}
			if (!jobSeeker.getPassword().equals(jobSeeker.getPassword_rep())) {
				return new ErrorResult("Girilen şifreler birbiriyle eşleşmiyor.");
			}
			else {
				jobSeeker.setStatu(2);
				jobSeeker.setUsertype(2);
				jobSeekerDao.save(jobSeeker);
				return new SuccessResult("Üyelik başarılı bir şekilde oluşturuldu. Email onayınız yapıldıktan sonra sistemi kullanmaya başlayabilirsiniz.");
			}
	}
	
	private boolean dataControl(JobSeeker jobSeeker)
	{
		if (jobSeeker.getEmail() == null || jobSeeker.getEmail().isBlank() ||
			jobSeeker.getFirstname() == null || jobSeeker.getFirstname().isBlank() ||
			jobSeeker.getLastname() == null || jobSeeker.getLastname().isBlank() || 
			jobSeeker.getNationalIdentity() == null || jobSeeker.getNationalIdentity().isBlank() ||
			jobSeeker.getPassword() == null || jobSeeker.getPassword().isBlank() ||
			jobSeeker.getTelephone() == null || jobSeeker.getTelephone().isBlank()||
			jobSeeker.getDate()==0)
			 {
			return false;
		}
		else {
			return true;
		}
	}
	
}
