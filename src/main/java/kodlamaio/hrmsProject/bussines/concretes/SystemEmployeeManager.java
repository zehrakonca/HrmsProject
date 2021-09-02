package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.SystemEmployeeService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.core.validations.concretes.MailValidation;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

	private SystemEmployeeDao systemEmployeeDao;
	private JobSeekerDao jobSeekerDao;
	private EmployerDao employerDao;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao,JobSeekerDao jobSeekerDao, EmployerDao employerDao) {
		super();
		this.systemEmployeeDao = systemEmployeeDao;
		this.employerDao=employerDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>(this.systemEmployeeDao.findAll(), "sistem çalışanı bilgisi listelendi.");
	}

	@Override
	public Result add(SystemEmployee systemEmployee) {
		if(!dataControl(systemEmployee)) {
			return new ErrorResult("Kayıt için eksik değer girildi, kontrol edip tekrar deneyin.");
		}
		if (!MailValidation.checkEmail(systemEmployee.getEmail())) {
			return new ErrorResult("Email hatalı."+ systemEmployee.getEmail());
		}
		if (systemEmployeeDao.findByEmail(systemEmployee.getEmail())!=null) {
			return new ErrorResult("E-Posta adresiniz sistemde kayıtlıdır.");
		}
		else {
			 systemEmployeeDao.save(systemEmployee);
			 return new SuccessResult("Sisteme kaydınız işlenmiştir.");
		}
		
	}
	
	@Override
	public Result update(SystemEmployee systemEmployee) {
		systemEmployeeDao.save(systemEmployee);
		 return new SuccessResult("Profil bilgisi güncellenmiştir.");
	}

	@Override
	public Result delete(int employeeId) {
		this.systemEmployeeDao.deleteById(employeeId);
		return new SuccessResult("Profil bilgisi silindi.");
	}
	
	private boolean dataControl(SystemEmployee systemEmployee)
	{
		if(systemEmployee.getFirstname() == null || systemEmployee.getFirstname().isBlank() ||
		   systemEmployee.getLastname()==null|| systemEmployee.getLastname().isBlank() ||
		   systemEmployee.getEmail()==null ||systemEmployee.getEmail().isBlank()||
		   systemEmployee.getNational_identity()==null || systemEmployee.getNational_identity().isBlank()||
		   systemEmployee.getTelephone() ==null ||systemEmployee.getTelephone().isBlank())
		{
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public Result updateMemberData(JobSeeker jobSeeker) {
		jobSeekerDao.getById(jobSeeker.getId());
		//jobSeeker.setStatu(1); bu koda gerek yok şuanlık swaggerdan elle yazıyorum.
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan bilgisi güncellendi.");
		}

	@Override
	public Result updateEmployerData(Employer employer) {
		employerDao.getById(employer.getEmployerId());
		//employer.setStatu(1);
		employerDao.save(employer);
		return new SuccessResult("İşveren bilgisi güncellendi.");
	}

	

}
