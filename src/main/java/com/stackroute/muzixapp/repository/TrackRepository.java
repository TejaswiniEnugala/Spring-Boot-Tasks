package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
//trackrepository interface creation
public interface TrackRepository extends JpaRepository<Track,Integer> {
}
