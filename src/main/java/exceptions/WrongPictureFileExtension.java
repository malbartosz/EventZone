package exceptions;


public class WrongPictureFileExtension extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongPictureFileExtension(final String msg) {
		super(msg);
	}
}
