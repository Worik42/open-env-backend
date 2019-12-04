package ru.kemsu.openenv.dto;

import java.util.ArrayList;

public class MapDTO {
    private String name;
    private Double[] position;
    private ArrayList<String> descriptions;

    public MapDTO() {
    }

    public String getName() {
        return name;
    }

    public Double[] getPosition() {
        return position;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }

}
