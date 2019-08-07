package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
public class TrackDAOImpl implements TrackDAO {
    private TrackRepository trackRepository;

    @Autowired
    public TrackDAOImpl(TrackRepository trackRepository) {
        this.trackRepository=trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException();
        }
        Track savedTrack=trackRepository.save(track);
        if(savedTrack==null)
        {
            throw new TrackAlreadyExistsException();
        }
        return savedTrack;
    }

    //getting all the tracks
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) {
        return trackRepository.save(getTrackById(id));
    }
    //updating the track by setting name and comment
    @Override
    public Track UpdateTrack(Track track) throws  TrackNotFoundException {
        Track savedTrack=new Track();
        if(trackRepository.existsById(track.getId())) {
             savedTrack = trackRepository.getOne(track.getId());
                    }
      return saveTrack(track);
    }
    public List<Track> findByName(String name){
        return trackRepository.findByName(name);
    }
}