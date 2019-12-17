package ru.kemsu.openenv.service;

import ru.kemsu.openenv.model.GeoCoord;

import java.util.List;

public interface MapService {

    GeoCoord find(String id);

    GeoCoord findByCoordinate(String geoCoordName);

    List<GeoCoord> findAll();

}
