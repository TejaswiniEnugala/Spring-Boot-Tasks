package com.stackroute.muzixapp.service;


import java.util.List;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.domain.Track;
//different track operations
public interface TrackDAO {

	public Track saveTrack(Track track) throws TrackAlreadyExistsException;

	public List<Track>getAllTracks() throws TrackNotFoundException;

	public int deleteTrack(long id);

	public Track getTrackById(int id) throws TrackNotFoundException;

	public List<Track> getTrackbyName(String name);

	void getTopTracks();

	public Track UpdateTrack(int id, Track track)throws TrackNotFoundException;



}