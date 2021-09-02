package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrmsProject.bussines.abstracts.CoverLetterService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager  implements CoverLetterService{

	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("ön yazı eklendi.");
	}
	
	@Override
	public Result delete(int coverLetterId) {
		this.coverLetterDao.deleteById(coverLetterId);
		return new SuccessResult("ön yazı silindi.");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("ön yazı güncellendi.");
	}

	@Override
	public DataResult<CoverLetter> getById(int coverLetterId) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getById(coverLetterId));
	}

	@Override
	public DataResult<CoverLetter> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<CoverLetter>
		(this.coverLetterDao.getByJobSeeker(jobSeekerId),"Data listelendi");
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	

}
