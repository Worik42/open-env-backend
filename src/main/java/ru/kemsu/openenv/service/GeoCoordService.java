package ru.kemsu.openenv.service;

import ru.kemsu.openenv.model.GeoCoord;

import java.util.List;

public interface GeoCoordService {

    GeoCoord create(GeoCoord object);

    GeoCoord find(String id);

    GeoCoord findByName(String geoCoordName);

    List<GeoCoord> findAll();

    GeoCoord update(String id, GeoCoord object);

    String delete(String id);
}
