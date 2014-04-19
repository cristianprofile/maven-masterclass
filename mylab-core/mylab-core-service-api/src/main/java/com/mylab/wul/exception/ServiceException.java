package com.mylab.wul.exception;

public abstract class ServiceException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = 6891262195785173370L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
