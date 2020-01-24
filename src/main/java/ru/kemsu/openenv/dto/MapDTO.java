package ru.kemsu.openenv.dto;

import ru.kemsu.openenv.model.Coordinate;

import java.io.Serializable;
import java.util.ArrayList;

public class MapDTO implements Serializable {
    private ArrayList<Coordinate> coord;


    public MapDTO() {
    }

    public ArrayList<Coordinate> getCoordinate() {
        return coord;
    }

}
