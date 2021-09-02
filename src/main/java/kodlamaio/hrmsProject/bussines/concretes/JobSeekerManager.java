package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrmsProject.bussines.abstracts.JobSeekerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.validations.concretes.MailValidation;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.dtos.CvDto;
import kodlamaio.hrmsProject.entities.dtos.converter.Converter;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private final JobSeekerDao jobSeekerDao;
	private final Converter converter;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, Converter converter) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.converter = converter;
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
//			else if(!identityValidationService.validate(jobSeeker.getNationalIdentity()))
//			{
//				return new ErrorResult("Girilen kimlik numarası geçersizdir.");
//			}
			else {
				jobSeeker.setStatu(2);
				jobSeeker.setUsertype(2);
				jobSeekerDao.save(jobSeeker);
				return new SuccessResult("Üyelik başarılı bir şekilde oluşturuldu. Email onayınız yapıldıktan sonra sistemi kullanmaya başlayabilirsiniz.");
			}
	}
	
	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("iş arayan bilgisi güncellendi.");
	}

	@Override
	public Result delete(int jobSeekerId) {
		this.jobSeekerDao.deleteById(jobSeekerId);
		return new SuccessResult("iş arayan bilgisi silindi.");
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
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByEmail(email));
	}

	@Override
	public DataResult<List<CvDto>> getAllCvByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<CvDto>>(this.jobSeekerDao.findById(jobSeekerId).stream().map(converter::convertToCv).collect(Collectors.toList()), "data listelendi");
	}

	@Override
	public DataResult<List<CvDto>> getAllCv() {
		return new SuccessDataResult<List<CvDto>>(this.jobSeekerDao.findAll().stream().map(converter::convertToCv).collect(Collectors.toList()),"data listelendi.");
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
