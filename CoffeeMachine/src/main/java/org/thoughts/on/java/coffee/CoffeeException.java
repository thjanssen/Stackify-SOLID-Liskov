package org.thoughts.on.java.coffee;

public class CoffeeException extends Exception {

	private static final long serialVersionUID = -4772254836087878052L;

	public CoffeeException() {
		super();
	}

	public CoffeeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CoffeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CoffeeException(String message) {
		super(message);
	}

	public CoffeeException(Throwable cause) {
		super(cause);
	}

}
