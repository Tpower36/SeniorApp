package ch.hackathon.asdf.seniorapp.services;

import android.content.Context;

import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.persistence.dao.EventDao;

/**
 * Created by thierry.hubmann on 30.01.2016.
 */
public class EventsServices {

    public static List<Event> getAllEvents(Context context){
        EventDao dao = new EventDao(context);
        dao.open();
        List<Event> events = dao.getAllEvents();
        dao.close();
        return events;
    }
}
