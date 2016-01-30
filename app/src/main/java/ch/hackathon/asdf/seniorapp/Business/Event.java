package ch.hackathon.asdf.seniorapp.Business;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by thierry.hubmann on 30.01.2016.
 */
public class Event implements Serializable {
    private long id;
    private String title;
    private String description;
    private Date eventDate;
    private String location;

    public Event(String title, String description, Date eventDate) {
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
    }

    public Event(String title, String description, Date eventDate, String location) {
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
