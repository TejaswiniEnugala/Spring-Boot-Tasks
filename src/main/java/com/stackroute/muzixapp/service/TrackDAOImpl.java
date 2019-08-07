package com.stackroute.muzixapp.service;

import java.util.List;

import javax.transaction.Transactional;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackDAOImpl implements TrackDAO {
private TrackRepository trackRepository;
	@Autowired
	public TrackDAOImpl(TrackRepository trackRepository) {
		this.trackRepository=trackRepository;
	}
	//implement all the methods
	@Override
	//override save track method
	public Track saveTrack(Track track) throws TrackAlreadyExistsException {
		if(trackRepository.existsById(track.getId())){
			throw new TrackAlreadyExistsException("userAlreadyExists");
		}
		Track savedTrack=trackRepository.save(track);
		if(savedTrack==null)
		{
			throw new TrackAlreadyExistsException("User already exists");
		}

		return savedTrack;
	}
	@Override
	//override delete track method
	public List<Track> deleteTrack(int id) throws TrackNotFoundException {
		if(trackRepository.existsById(id)) {
			trackRepository.deleteById(id);

		}
		else {
			throw new TrackNotFoundException("track does not exists");
		}
		return trackRepository.findAll();
	}

//to get all tracks
	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();
	}

	@Override
	public Track getTrackById(int id) {
		return trackRepository.save(getTrackById(id));

	}
//to update tracks
	@Override
	public Track UpdateTrack(Track track) {
		Track tracks=trackRepository.save(track);
		return tracks;
	}
	public List<Track> findByName(String name)
	{
		return  trackRepository.findByName(name);
	}

}
