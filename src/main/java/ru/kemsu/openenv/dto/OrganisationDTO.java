package ru.kemsu.openenv.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class OrganisationDTO implements Serializable {

    private String name;
    private Double[] position;
    private ArrayList<String> descriptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getPosition() {
        return position;
    }

    public void setPosition(Double[] position) {
        this.position = position;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(ArrayList<String> descriptions) {
        this.descriptions = descriptions;
    }

    public OrganisationDTO() {
    }

}
