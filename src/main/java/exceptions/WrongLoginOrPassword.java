package exceptions;


public class WrongLoginOrPassword extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongLoginOrPassword(final String msg) {
		super(msg);
	}
}
