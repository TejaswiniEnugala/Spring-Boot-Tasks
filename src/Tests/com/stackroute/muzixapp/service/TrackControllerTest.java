package com.stackroute.muzixapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.TrackApplication;
import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFoundException;
import com.stackroute.muzixapp.controller.TrackController;
import com.stackroute.muzixapp.domain.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TrackApplication.class)
@WebMvcTest
public class TrackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Track track;

    //Inject the mocks as dependencies into UserServiceImpl
    @MockBean
    private TrackDAO trackDAO;

    @InjectMocks
    private TrackController trackController;

    private List<Track> list= null;

    @Before
    public void setUp(){
          //Initialising the mock object
          MockitoAnnotations.initMocks(this);
          mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
          track = new Track();
          track.setId(123);
          track.setName("teju");
          track.setComment("try to do");
          list = new ArrayList<>();
          list.add(track);
    }

    @Test
    public void saveTrackTestSuccess() throws Exception {
        when(trackDAO.saveTrack((Track) any())).thenReturn(track);

        mockMvc.perform(post("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .content((asJsonString(track))))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    private String asJsonString(Track track) throws JsonProcessingException {
        try {
            return new ObjectMapper().writeValueAsString(track);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void getAllUser() throws Exception {
        mockMvc.perform(get("/api/v1/trackuser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .content((asJsonString(track))))
                .andExpect(status().isOk())
                .andDo(print());
       // List<Track> tracklist = trackDAO.getAllTracks();
        //Assert.assertEquals(list,tracklist);
    }

    @Test
    public void updateTrack() throws Exception {
        when(trackDAO.saveTrack((Track) any())).thenReturn(track);

        mockMvc.perform(put("/api/v1/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON)
                .content((asJsonString(track))))
                .andExpect(status().isOk())
                .andDo(print());
    }
}