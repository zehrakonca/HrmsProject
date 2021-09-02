package kodlamaio.hrmsProject.bussines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrmsProject.bussines.abstracts.ParticipationStatuService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.ParticipationStatuDao;
import kodlamaio.hrmsProject.entities.concretes.ParticipationStatus;

@Service
public class ParticipationStatuManager implements ParticipationStatuService{

	@Autowired
	public ParticipationStatuManager(ParticipationStatuDao participationStatuDao) {
		super();
		this.participationStatuDao = participationStatuDao;
	}

	private ParticipationStatuDao participationStatuDao;	
	
	@Override
	public DataResult<List<ParticipationStatus>> getAll() {
		return new SuccessDataResult<List<ParticipationStatus>>(this.participationStatuDao.findAll());
	}

	@Override
	public Result add(ParticipationStatus participationStatus) {
		this.participationStatuDao.save(participationStatus);
		return new SuccessResult("Durum eklendi.");
	}

	@Override
	public Result update(ParticipationStatus participationStatus) {
		this.participationStatuDao.save(participationStatus);
		return new SuccessResult("Durum güncellendi.");
	}

	@Override
	public Result delete(int participationStatuId) {
		this.participationStatuDao.deleteById(participationStatuId);
		return new SuccessResult("Durum silindi.");
	}

}
