/*
 * Copyright 2009 the original author or authors.
 */

package pl.com.softproject.utils.jdbc.exceptions;

/**
 *
 * @author Adrian Lapierre <alapierre@softproject.com.pl>
 */
public class CreateConnectionException extends DataAccessException {

    public CreateConnectionException() {
    }

    public CreateConnectionException(String message) {
        super(message);
    }

    public CreateConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateConnectionException(Throwable cause) {
        super(cause);
    }

    

}
