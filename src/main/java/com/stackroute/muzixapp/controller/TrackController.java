package com.stackroute.muzixapp.controller;
import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.service.TrackDAO;
import com.stackroute.muzixapp.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1")
public class TrackController {

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
		ResponseEntity responseEntity;
		try {
			trackDAO.saveTrack(track);
			responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
		} catch (TrackAlreadyExistsException e){
			responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}

		return responseEntity;

	}
	//delete the track
	@DeleteMapping("track")
	public ResponseEntity<?> deleteTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try {

			trackDAO.deleteTrack(track.getId());
			responseEntity = new ResponseEntity<String>("deleted successfully", HttpStatus.CREATED);
		} catch (TrackNotFoundException e){
		responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
	}
		return responseEntity;
	}
//get all tracks
	@PutMapping("update")
	public ResponseEntity<?> getAllTracks(){
		return new ResponseEntity<List<Track>>(trackDAO.getAllTracks(),HttpStatus.OK);
	}
	@GetMapping("retrieve/{name}")
	public ResponseEntity<?> findByName(@PathVariable(value = "name")String name){
		ResponseEntity responseEntity;
		try {
			responseEntity = new ResponseEntity<List>(trackDAO.findByName(name), HttpStatus.OK);
		} finally {

		}

		return responseEntity;
	}
	@GetMapping("track")
	public ResponseEntity<?> getAllTheTracks(){
		return new ResponseEntity< List<Track> >(trackDAO.getAllTracks(),HttpStatus.OK);
	}
}