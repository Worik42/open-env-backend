package ru.kemsu.openenv.model;

import java.io.Serializable;
import java.util.List;

public class GeoCoord extends BaseEntity implements Serializable {

    private List<Coordinate> coordinate;

    public List<Coordinate> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(List<Coordinate> coordinate) {
        this.coordinate = coordinate;
    }
}
