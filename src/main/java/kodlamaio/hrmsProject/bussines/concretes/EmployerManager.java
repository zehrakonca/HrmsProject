package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.EmployerService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.validations.concretes.MailValidation;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "data listelendi.");
	}
	
	@Override
	public Result add(Employer employer) {
		if (!dataControl(employer)) {
			return new ErrorResult("Kayıt için eksik değer girildi, kontrol edip tekrar deneyin.");
		}
		if (!MailValidation.checkEmail(employer.getCompanyMail())) {
			return new ErrorResult("Email hatalı."+ employer.getCompanyName());
		}
		if (!MailValidation.checkEmailDomain(employer.getWeb_site_name(), employer.getCompanyMail())) {
			return new ErrorResult("Email ve girilen web adresi uyumlu değil");
		}
		if (employerDao.findBycompanyMail(employer.getCompanyMail())!=null){
			return new ErrorResult("Bu e-mail ile alınmış bir kaydınız zaten bulunmakta.");
		}
		if (!employer.getPassword().equals(employer.getPassword_rep())) {
			return new ErrorResult("Girilen şifreler birbiriyle eşleşmiyor.");
		}
		else {
			employer.setStatu(2);
			employer.setUsertype(1);
			employerDao.save(employer);
			return new SuccessResult("Üyelik başarılı bir şekilde oluşturuldu. Email onayınız yapıldıktan sonra sistemi kullanmaya başlayabilirsiniz.");
		}
	}
	
	@Override
	public Result update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessResult("İşveren bilgisi güncellendi.");
	}

	@Override
	public Result delete(int employerId) {
		this.employerDao.deleteById(employerId);
		return new SuccessResult("İşveren bilgisi silindi.");
	}
	private boolean dataControl (Employer employer)
	{
		if(employer.getCompanyMail() == null || employer.getCompanyMail().isBlank() || employer.getPassword()==null ||employer.getPassword() .isBlank() || employer.getPassword_rep() == null ||  employer.getPassword_rep().isBlank() || employer.getCompanyName() ==null ||employer.getCompanyName().isBlank() || employer.getWeb_site_name()==null ||employer.getWeb_site_name().isBlank() || employer.getTelephone() ==null || employer.getTelephone().isBlank()) {
			return false;
		}
		else {
			return true;
		}
	}

	

}
