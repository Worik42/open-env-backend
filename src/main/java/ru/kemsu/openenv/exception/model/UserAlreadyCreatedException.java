package ru.kemsu.openenv.exception.model;

public class UserAlreadyCreatedException extends RuntimeException {
    public UserAlreadyCreatedException() {
    }

    public UserAlreadyCreatedException(String message) {
        super(message);
    }

    public UserAlreadyCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
