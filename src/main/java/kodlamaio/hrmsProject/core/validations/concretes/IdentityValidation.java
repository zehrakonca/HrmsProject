package kodlamaio.hrmsProject.core.validations.concretes;

//import java.rmi.RemoteException;
//import java.util.Locale;


//import java.util.Locale;

import kodlamaio.hrmsProject.core.validations.abstracts.IdentityValidationService;
//import kodlamaio.hrmsProject.entities.concretes.JobSeeker;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class IdentityValidation implements IdentityValidationService{

	@Override
	public boolean validate(String identityNumber) {
		return true;
	}

	/*@Override
	public boolean isIdentityTrue(JobSeeker jobSeeker)
	{
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalIdentity()), 
					jobSeeker.getFirstname().toUpperCase(new Locale("tr")), 
					jobSeeker.getLastname().toUpperCase(new Locale("tr")),
					jobSeeker.getDate()
					);
		} catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}*/
}
