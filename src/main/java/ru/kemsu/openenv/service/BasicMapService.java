package ru.kemsu.openenv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kemsu.openenv.model.GeoCoord;
import ru.kemsu.openenv.repository.GeoCoordRepository;

import java.util.List;

@Service
public class BasicMapService implements MapService {

    private final GeoCoordRepository repository;

    @Autowired
    public BasicMapService(final GeoCoordRepository repository) {
        this.repository = repository;
    }

    @Override
    public GeoCoord find(final String id) {
        return repository.findById(id).get();
    }

    @Override
    public GeoCoord findByCoordinate(final String geoCoordName) {
        return repository.findByCoordinate(geoCoordName);
    }

    @Override
    public List<GeoCoord> findAll() {
        return repository.findAll();
    }

}
