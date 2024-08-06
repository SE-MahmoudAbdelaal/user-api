package com.fawry.user_api.Exceptions.customExceptions;

public class NotAuthToSeeResourseException extends RuntimeException {

    public NotAuthToSeeResourseException() {
    }

    public NotAuthToSeeResourseException(String message) {
        super(message);

    }

    public NotAuthToSeeResourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAuthToSeeResourseException(Throwable cause) {
        super(cause);
    }

    public NotAuthToSeeResourseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}