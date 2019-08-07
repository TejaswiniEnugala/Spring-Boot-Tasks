package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TrackDAOTest {
    Track track;
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    TrackDAOImpl trackimpl;
    List<Track> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(123);
        track.setName("teju");
        track.setComment("try to do");
        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTest() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track track1 = trackimpl.saveTrack(track);
        Assert.assertEquals(track, track1);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository, times(1)).save(track);

    }
    @Test
    public void getallTracks(){
List<Track> list=new ArrayList<>();
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> track1 = trackimpl.getAllTracks();
        Assert.assertEquals(list, track1);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository, times(1)).findAll();

    }
    @Test
    public void updateTrack() throws TrackNotFoundException {
        when(trackRepository.save((Track) any())).thenReturn(track);
        Track track1 = trackimpl.UpdateTrack(track);
        Assert.assertEquals(track, track1);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository, times(1)).save(track);


    }

}


