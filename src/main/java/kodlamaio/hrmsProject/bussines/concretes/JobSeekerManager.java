package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.CoverLetterService;
import kodlamaio.hrmsProject.bussines.abstracts.ImageService;
import kodlamaio.hrmsProject.bussines.abstracts.JobCompetencyService;
import kodlamaio.hrmsProject.bussines.abstracts.JobExperienceService;
import kodlamaio.hrmsProject.bussines.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.bussines.abstracts.LanguageService;
import kodlamaio.hrmsProject.bussines.abstracts.SchoolService;
import kodlamaio.hrmsProject.bussines.abstracts.SocialMediaAccountService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.validations.abstracts.IdentityValidationService;
import kodlamaio.hrmsProject.core.validations.concretes.MailValidation;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.dtos.CvDto;
import kodlamaio.hrmsProject.entities.dtos.JobSeekerDto;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private IdentityValidationService identityValidationService;
	private CoverLetterService coverLetterService;
	private ImageService imageService;
	private SchoolService schoolService;
	private JobExperienceService jobExperienceService;
	private JobCompetencyService jobCompetencyService;
	private LanguageService languageService;
	private SocialMediaAccountService socialMediaAccountService;
	
	
	@Autowired
	public JobSeekerManager(IdentityValidationService identityValidationService,
			                CoverLetterService coverLetterService,
			                ImageService imageService, 
			                SchoolService schoolService,
			                JobExperienceService jobExperienceService,
			                JobCompetencyService jobCompetencyService, 
			                LanguageService languageService,
			                SocialMediaAccountService socialMediaAccountService) 
	{
		super();
		this.identityValidationService = identityValidationService;
		this.coverLetterService = coverLetterService;
		this.imageService = imageService;
		this.schoolService = schoolService;
		this.jobExperienceService = jobExperienceService;
		this.jobCompetencyService = jobCompetencyService;
		this.languageService = languageService;
		this.socialMediaAccountService = socialMediaAccountService;
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
			
			else if (jobSeekerDao.findByEmail(jobSeeker.getEmail())!=null){
				return new ErrorResult("E-Posta adresiniz sistemde kayıtlıdır.");
			}
			else if (jobSeekerDao.findByNationalIdentity(jobSeeker.getNationalIdentity())!=null) {
				return new ErrorResult("Kimlik numaranız sistemde kayıtlıdır.");
			}
			else if (!jobSeeker.getPassword().equals(jobSeeker.getPassword_rep())) {
				return new ErrorResult("Girilen şifreler birbiriyle eşleşmiyor.");
			}
			else if(!identityValidationService.validate(jobSeeker.getNationalIdentity()))
			{
				return new ErrorResult("Girilen kimlik numarası geçersizdir.");
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

	@Override
	public DataResult<JobSeeker> getById(int jobSeekerId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(jobSeekerId));
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalIdentity(identityNumber));
	}


	@Override
	public DataResult<List<JobSeekerDto>> getJobSeekerDto() {
		return new SuccessDataResult<List<JobSeekerDto>>(this.jobSeekerDao.getDetail());
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByEmail(email));
	}
	
	@Override
	public DataResult<CvDto> getJobSeekerCv(int jobSeekerId) {
		CvDto cv = new CvDto();
		cv.setJobSeeker(this.getById(jobSeekerId).getData());
		cv.setImage(this.imageService.getByJobSeekerId(jobSeekerId).getData());
		cv.setSchools(this.schoolService.getByJobSeekerId(jobSeekerId).getData());
		cv.setJobExperiences(this.jobExperienceService.getByJobSeekerId(jobSeekerId).getData());
		cv.setJobCompetencies(this.jobCompetencyService.getByJobSeekerId(jobSeekerId).getData());
		cv.setSocialMediaAccounts(this.socialMediaAccountService.getByJobSeekerId(jobSeekerId).getData());
		cv.setLanguages(this.languageService.getByJobSeekerId(jobSeekerId).getData());
		cv.setCoverLetter(this.coverLetterService.getByJobSeekerId(jobSeekerId).getData());
		return new SuccessDataResult<CvDto>(cv);
		}
	
}
