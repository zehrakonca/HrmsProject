package kodlamaio.hrmsProject.bussines.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterService extends BaseEntitiyService<CoverLetter> {
	DataResult<CoverLetter> getByJobSeekerId(int jobSeekerId);
}
