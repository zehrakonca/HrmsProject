package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.ParticipationStatus;

public interface ParticipationStatuService {
	DataResult<List<ParticipationStatus>> getAll();

	Result add(ParticipationStatus participationStatus);

	Result update(ParticipationStatus participationStatus);

	Result delete(int participationStatuId);
}
