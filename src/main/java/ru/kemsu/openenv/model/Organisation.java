package ru.kemsu.openenv.model;

import java.io.Serializable;

public class Organisation extends BaseEntity implements Serializable {

    private String name;
    private String position;
    private String descriptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }


}
