package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {
@Autowired
    TrackRepository trackRepository;
Track track;
List<Track> list;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(123);
        track.setName("teju");
        track.setComment("try to do");
        list = new ArrayList<>();
        list.add(track);
    }
    @Test
    public void testSaveTrack(){
       List<Track> track2 = (List<Track>) trackRepository.save(track);
        Track track1 = (Track) trackRepository.saveAll(track2);
        Assert.assertEquals(123,track1.getId());

    }
    @Test
    public void testgetAllTracks(){
        trackRepository.save(track);
        List<Track> list1 = (List<Track>) trackRepository.findAll();
        Assert.assertEquals(list,list1);
    }

    @Test
    public void testupdateTrack()
    {

        track.setId(145);
        trackRepository.save(track);
        Optional<Track> track1 = trackRepository.findById(track.getId());
        Assert.assertEquals(145,track.getId());
    }
}