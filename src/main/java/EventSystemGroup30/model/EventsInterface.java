package EventSystemGroup30.model;

import EventSystemGroup30.persistance.Event;

import java.util.ArrayList;

public interface EventsInterface {

    void addEvent(String eventName);

    ArrayList<Event> getAllEvents();

}
