package ch.hackathon.asdf.seniorapp.services;

import android.content.Context;

import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.persistence.dao.EventDao;

/**
 * Created by thierry.hubmann on 30.01.2016.
 */
public class EventsServices {

    /**
     * Service retournant la liste de tous les événements
     *
     * @param context
     * @return la liste des événements
     */
    public static List<Event> getAllEvents(Context context) {
        EventDao dao = new EventDao(context);
        dao.open();
        List<Event> events = dao.getAllEvents();
        dao.close();
        return events;
    }

    /**
     * Service retournant un Event par rapport à son id
     * @param context
     * @param id l'id de l'event
     * @return l'event
     */
    public static Event getEventById(Context context, Long id){
        EventDao dao = new EventDao(context);
        dao.open();
        Event event = dao.getEventById(id);
        dao.close();
        return event;
    }

    /**
     * Service permettant d'ajouter un événement
     *
     * @param event l'événement
     * @return un code erreur, 0 si tout est ok
     */
    public static int addEvent(Context context, Event event) {
        EventDao dao = new EventDao(context);
        if(event != null) {
            dao.open();
            dao.createEvent(event);
            dao.close();
            return 0;
        }
        else{
            return 1;
        }

    }
    public static int editEvent(Context context, Event event){
        EventDao dao = new EventDao(context);
        if(event != null) {
            dao.open();
            dao.updateEvent(event);
            dao.close();
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int deleteEvent(Context context, Event event){
        EventDao dao = new EventDao(context);
        if(event != null) {
            dao.open();
            dao.deleteEvent(event);
            dao.close();
            return 0;
        }
        else{
            return 1;
        }
    }
}
