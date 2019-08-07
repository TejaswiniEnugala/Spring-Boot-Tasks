package com.stackroute;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.service.TrackDAO;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListen implements ApplicationListener<ContextRefreshedEvent> {
    TrackDAO trackDAO;
    public ApplicationListen(TrackDAO trackDAO){
        this.trackDAO=trackDAO;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try
        {
            Track track=new Track(1,"bekhaliya","from singh");
            trackDAO.saveTrack(track);
            for(Track track1:trackDAO.getAllTracks())
            {
                System.out.println(trackDAO.getAllTracks());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}