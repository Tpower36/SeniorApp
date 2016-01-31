package ch.hackathon.asdf.seniorapp.persistence.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ch.hackathon.asdf.seniorapp.Business.Event;
import ch.hackathon.asdf.seniorapp.persistence.dbhelper.DBHelper;

/**
 * Created by thierry.hubmann on 30.01.2016.
 */
public class EventDao {
    // Champs de la base de données
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = { DBHelper.EVENTS_ID,DBHelper.EVENTS_TITLE, DBHelper.EVENTS_DESCRIPTION,
            DBHelper.EVENTS_DATE, DBHelper.EVENTS_LOCATION};

    public EventDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    /**
     * Cette méthode permet d'insérer un évéenement dans la base de données
     * @param event l'événement à insérer
     */
    public void createEvent(Event event) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.EVENTS_TITLE, event.getTitle());
        if(event.getDescription() != null){
            values.put(DBHelper.EVENTS_DESCRIPTION, event.getDescription());
        }
        values.put(DBHelper.EVENTS_DATE, event.getEventDate().toString());
        if(event.getLocation() != null){
            values.put(DBHelper.EVENTS_LOCATION, event.getLocation());
        }

        long insertId = database.insert(DBHelper.TABLE_EVENTS, null,
                values);
    }

    /**
     * Cette méthode permet de supprimer un événement de la base de données
     * @param event l'événement à supprimer
     */
    public void deleteEvent(Event event) {
        long id = event.getId();
        database.delete(DBHelper.TABLE_EVENTS, DBHelper.EVENTS_ID
                + " = " + id, null);
    }

    /**
     * Cette méthode retourne tous les événements contenus dans la base de données
     * @return la liste des événements
     */
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        Cursor cursor = null;
        try {
            cursor = database.query(DBHelper.TABLE_EVENTS,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Event event = cursorToEvent(cursor);
                events.add(event);
                cursor.moveToNext();
            }
        }
        catch(NullPointerException ex){
            return null;
        }
        cursor.close();
        return events;
    }

    public Event getEventById(long id){
        Event event = null;
        Cursor cursor = null;
        try {
            cursor = database.query(DBHelper.TABLE_EVENTS,
                    allColumns, "id="+id, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
               event = cursorToEvent(cursor);
                cursor.moveToNext();
            }
        }
        catch(NullPointerException ex){
            return null;
        }
        cursor.close();
        return event;
    }
    public void updateEvent(Event event){
        ContentValues values = new ContentValues();
        values.put(DBHelper.EVENTS_TITLE, event.getTitle());
        if(event.getDescription() != null){
            values.put(DBHelper.EVENTS_DESCRIPTION, event.getDescription());
        }
        values.put(DBHelper.EVENTS_DATE, event.getEventDate().toString());
        if(event.getLocation() != null){
            values.put(DBHelper.EVENTS_LOCATION, event.getLocation());
        }

        long insertId = database.update(DBHelper.TABLE_EVENTS, values,
                "id=" + event.getId(), null);
        Cursor cursor = database.query(DBHelper.TABLE_EVENTS,
                allColumns, DBHelper.EVENTS_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();
    }

    private Event cursorToEvent(Cursor cursor) {
        Event event = new Event();
        event.setId(cursor.getLong(0));
        event.setTitle(cursor.getString(1));
        event.setDescription(cursor.getString(2));
        event.setEventDate(cursor.getString(3));
        if(cursor.getString(4) != null) {
            event.setLocation(cursor.getString(4));
        }

        return event;
    }
}
