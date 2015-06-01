package exceptions;


public class WrongBackgroundFileExtension extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongBackgroundFileExtension(final String msg) {
		super(msg);
	}
}
