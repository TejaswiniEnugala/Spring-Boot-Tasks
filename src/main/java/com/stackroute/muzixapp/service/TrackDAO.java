package com.stackroute.muzixapp.service;


import java.util.List;
import com.stackroute.muzixapp.domain.Track;
//different track operations
public interface TrackDAO {

	public Track saveTrack(Track track);

	public void deleteTrack(int id);

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public Track UpdateTrack(Track track);
	public List<Track> findByName(String name);


   
}