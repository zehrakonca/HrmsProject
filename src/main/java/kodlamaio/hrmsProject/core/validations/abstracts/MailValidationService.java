package kodlamaio.hrmsProject.core.validations.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;

public interface MailValidationService {

	Result validate(String email);
}
