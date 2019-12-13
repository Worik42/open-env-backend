package ru.kemsu.openenv.dto;

import ru.kemsu.openenv.model.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;

public class GeoCoordDTO implements Serializable {

    private ArrayList<Coordinate> coordinate;

    public ArrayList<Coordinate> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(ArrayList<Coordinate> coordinate) {
        this.coordinate = coordinate;
    }

    public GeoCoordDTO() {
    }
}
