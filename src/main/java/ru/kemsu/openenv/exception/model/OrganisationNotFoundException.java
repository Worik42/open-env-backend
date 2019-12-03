package ru.kemsu.openenv.exception.model;


public class OrganisationNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 2967357473314163159L;

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
