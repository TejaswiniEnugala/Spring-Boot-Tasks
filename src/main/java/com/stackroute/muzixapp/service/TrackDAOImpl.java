package com.stackroute.muzixapp.service;

import java.util.List;

import javax.transaction.Transactional;

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
	public Track saveTrack(Track track){

		Track savedTrack=trackRepository.save(track);

		return savedTrack;
	}
	@Override
	//override delete track method
	public List<Track> deleteTrack(int id) {

		trackRepository.deleteById(id);
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

}
