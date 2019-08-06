package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    //deleting the track by id
    @Override
    public List<Track> deleteTrack(int id) {
        trackRepository.deleteById(id);
        return trackRepository.findAll();
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
    public boolean UpdateTrack(Track track) throws  TrackNotFoundException {
        if(trackRepository.existsById(track.getId())) {
            boolean result = false;
            Track savedTrack = trackRepository.getOne(track.getId());
            savedTrack.setName(track.getName());
            savedTrack.setComment(track.getComment());
            trackRepository.save(savedTrack);
            if (savedTrack != null) {
                result = true;
            }
            return result;
        }
        else
            throw new TrackNotFoundException();


    }
    public List<Track> findByName(String name){
        return trackRepository.findByName(name);
    }
}