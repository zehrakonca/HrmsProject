package kodlamaio.hrmsProject.core.validations.abstracts;

import kodlamaio.hrmsProject.core.utilities.results.Result;

public interface IdentityValidationService {
	Result validate(String identityNumber);
}
