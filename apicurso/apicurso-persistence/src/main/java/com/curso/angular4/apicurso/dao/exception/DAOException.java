package com.curso.angular4.apicurso.dao.exception;

/**
 * The Class DAOException.
 */
public class DAOException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new DAO exception.
     */
    public DAOException() {
        super();
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param message
     *            the message
     */
    public DAOException(String message) {
        super(message);
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param cause
     *            the cause
     */
    public DAOException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new DAO exception.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
