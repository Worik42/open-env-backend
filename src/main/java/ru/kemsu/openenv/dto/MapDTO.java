package ru.kemsu.openenv.dto;

import ru.kemsu.openenv.model.Coordinate;

import java.util.ArrayList;

public class MapDTO {
    private String name;
    private ArrayList<Coordinate> position;
    private ArrayList<String> descriptions;

    public MapDTO() {
    }

    public String getName() {
        return name;
    }

    public ArrayList<Coordinate> getPosition() {
        return position;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }

}
