package ru.kemsu.openenv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kemsu.openenv.model.GeoCoord;
import ru.kemsu.openenv.repository.GeoCoordRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BasicGeoCoordService implements GeoCoordService {

    @Autowired
    private GeoCoordRepository repository;


    @Override
    public GeoCoord findByCoordinate(final String geoCoordname) {
        return repository.findByCoordinate(geoCoordname);
    }

    @Override
    public GeoCoord create(final GeoCoord geoCoord) {
        geoCoord.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(geoCoord);
    }

    @Override
    public GeoCoord find(final String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<GeoCoord> findAll() {
        return repository.findAll();
    }

    @Override
    public GeoCoord update(final String id, final GeoCoord geoCoord) {
        geoCoord.setId(id);

        final GeoCoord saved = repository.findById(id).get();

        if (saved != null) {
            geoCoord.setCreatedAt(saved.getCreatedAt());
            geoCoord.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            geoCoord.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(geoCoord);
        return geoCoord;
    }

    @Override
    public String delete(final String id) {
        repository.deleteById(id);
        return id;
    }

}
