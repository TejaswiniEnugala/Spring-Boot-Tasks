package com.stackroute.muzixapp.service;


import java.util.List;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.domain.Track;
//different track operations
public interface TrackDAO {

	public Track saveTrack(Track track) throws TrackAlreadyExistsException;

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public Track UpdateTrack(Track track) throws TrackNotFoundException;
	public List<Track> findByName(String name);


   
}