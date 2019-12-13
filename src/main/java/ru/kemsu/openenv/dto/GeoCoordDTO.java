package ru.kemsu.openenv.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class GeoCoordDTO implements Serializable {

    private ArrayList<CoordinateDTO> coordinate;

    public ArrayList<CoordinateDTO> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(ArrayList<CoordinateDTO> coordinate) {
        this.coordinate = coordinate;
    }

    public GeoCoordDTO() {
    }
}
