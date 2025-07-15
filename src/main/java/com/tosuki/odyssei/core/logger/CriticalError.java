package com.tosuki.odyssei.core.logger;

public class CriticalError extends CoreError {
    public String message;

    public CriticalError(String message) {
        super("critical", message);
    }

    /**
     * Exceptions that were thrown, but cannot be handled by the application, will throw an illegal exception
     */
    public static class IllegalException extends CriticalError {
        public IllegalException(Throwable exception) {
            super(exception.getMessage());
        }
    }
}
