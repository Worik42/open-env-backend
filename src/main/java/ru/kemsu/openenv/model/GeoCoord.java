package ru.kemsu.openenv.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GeoCoord extends BaseEntity implements Serializable {

    private ArrayList<Coordinate> coordinate;

    public ArrayList<Coordinate> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(ArrayList<Coordinate> coordinate) {
        this.coordinate = coordinate;
    }
}
