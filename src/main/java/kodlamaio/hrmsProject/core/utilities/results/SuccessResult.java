package kodlamaio.hrmsProject.core.utilities.results;

public class SuccessResult extends Result{
	public SuccessResult() {
		super(true);
	}
	public SuccessResult(String message) {
		super(true,message);
	}
	public SuccessResult(boolean b, String string) {
		super(true, string);
	}
	
}
