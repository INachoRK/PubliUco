package co.edu.uco.publiuco.crosscutting.exception;

public final class PubliucoAPIException extends PubliUcoException {

	private static final long serialVersionUID = -4636066115510646740L;

	private PubliucoAPIException(String technicalMessage, String userMessage, Throwable rootCause) {
		super(technicalMessage, userMessage, rootCause, ExceptionType.API);
	}

	public static PubliucoAPIException create(final String technicalMessage, final String userMessage,
			final Throwable rootCause) {
		return new PubliucoAPIException(technicalMessage, userMessage, rootCause);
	}

	public static PubliucoAPIException create(final String userMessage) {
		return new PubliucoAPIException(userMessage, userMessage, new Exception());
	}

	public static PubliucoAPIException create(final String technicalMessage, final String userMessage) {
		return new PubliucoAPIException(technicalMessage, userMessage, new Exception());
	}
}