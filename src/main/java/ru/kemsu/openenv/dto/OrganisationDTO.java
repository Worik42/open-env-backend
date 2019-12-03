package ru.kemsu.openenv.dto;

import java.io.Serializable;

public class OrganisationDTO implements Serializable {

    private static final long serialVersionUID = 91901774547107674L;// какой??

    private String name;
    private String position;
    private String descriptions;

    public OrganisationDTO() {
    }

    public String setName() {
        return name;
    }

    public void setName(final String username) {
        this.name = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(final String password) {
        this.position = password;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(final String password) {
        this.descriptions = password;
    }

}
