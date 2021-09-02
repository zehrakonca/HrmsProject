package kodlamaio.hrmsProject.bussines.abstracts;

import java.util.List;

import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterService {
	Result add (CoverLetter coverLetter);
	Result delete (int coverLetterId);
	Result update (CoverLetter coverLetter);
	DataResult<CoverLetter> getById(int coverLetterId);
	DataResult<CoverLetter> getByJobSeekerId(int jobSeekerId);
	DataResult<List<CoverLetter>> getAll();
}
