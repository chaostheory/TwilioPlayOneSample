package exceptions;

public class InterviewException extends Exception {
	public InterviewException(String string) {
		super(string);
	}
	public InterviewException(String string, Exception e) {
		super(string, e);
	}
}
