package ru.kemsu.openenv.exception.model;


public class OrganisationNotFoundException extends RuntimeException {

    public OrganisationNotFoundException() {
        super();
    }

    public OrganisationNotFoundException(final String message) {
        super(message);
    }

    public OrganisationNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
