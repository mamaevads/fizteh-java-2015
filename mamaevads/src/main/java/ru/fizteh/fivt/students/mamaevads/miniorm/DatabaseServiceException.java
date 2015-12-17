package ru.fizteh.fivt.students.mamaevads.miniorm;

public class DatabaseServiceException extends Exception {

    public DatabaseServiceException(String message) {
        super(message);
    }

    public DatabaseServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}