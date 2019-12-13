package ru.kemsu.openenv.model;

import java.io.Serializable;
import java.util.ArrayList;

public class OrgGeoJSON extends BaseEntity implements Serializable {

    private ArrayList<Double[]> position;

    public ArrayList<Double[]> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Double[]> position) {
        this.position = position;
    }


}
