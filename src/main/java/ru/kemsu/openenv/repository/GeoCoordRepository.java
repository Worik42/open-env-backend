package ru.kemsu.openenv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.kemsu.openenv.model.GeoCoord;

@Repository
public interface GeoCoordRepository extends MongoRepository<GeoCoord, String> {

    GeoCoord findByName(final String geoCoordName);

}
