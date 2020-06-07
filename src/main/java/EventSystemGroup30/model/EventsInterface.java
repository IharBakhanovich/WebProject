package EventSystemGroup30.model;

import EventSystemGroup30.persistance.Event;

import java.util.ArrayList;

public interface EventsInterface {

    void addEvent(String eventName);

    void persist(Event event);

    ArrayList<Event> getAllEvents();

}
