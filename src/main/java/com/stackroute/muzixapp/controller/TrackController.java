package com.stackroute.muzixapp.controller;
import com.stackroute.muzixapp.service.TrackDAO;
import com.stackroute.muzixapp.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
ResponseEntity responseEntity;
	@Autowired
	private TrackDAO trackDAO;

	public TrackController(TrackDAO trackDAO)
	{
		this.trackDAO=trackDAO;
	}
//save the track
	@PostMapping("track")
	public ResponseEntity<?> saveTrack(@RequestBody Track track)
	{

		try {
			trackDAO.saveTrack(track);
			responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
		} finally {

		}

		return responseEntity;

	}
	//delete the track
	@DeleteMapping("track")
	public ResponseEntity<?> deleteTrack(@RequestBody Track track)
	{

		try {

			trackDAO.deleteTrack(track.getId());
			responseEntity = new ResponseEntity<String>("deleted successfully", HttpStatus.CREATED);
		} finally {

		}
		return responseEntity;
	}
//get all tracks
	@GetMapping("track")
	public ResponseEntity<?> getAllTracks(){
		return new ResponseEntity<List<Track>>(trackDAO.getAllTracks(),HttpStatus.OK);
	}
}