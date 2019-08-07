package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;

//trackrepository interface creation
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

    @Query("SELECT u FROM Track u WHERE u.name = ?1")
    public List<Track> findByName(@Param("name") String name);
}
