package EventSystemGroup30.model;

import EventSystemGroup30.persistance.Event;
import EventSystemGroup30.persistance.EventDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;

/**
 * Eine ServiceClasse um services bereitzustellen
 */
public class Events implements EventsInterface {

    private ArrayList<Event> eventsList = new ArrayList<>();

    // brauchen nicht mehr in der Zukunft explizit Events einzulegen. Daten muss aus dem DB geholt werden.
//    public Events() {
//        Date date = new Date();
//        Event event = new Event();
//        event.setVenue("Passau");
//        event.setDate(date);
//        this.eventsList = new ArrayList<>();
//        this.eventsList.add(event);
//        this.eventsList.add(event);
//        this.eventsList.add(event);
//    }

    //um Daten aus dem Datenbank zu holen
    @Inject
    EventDAO eventDAO;

    @Override
    public void addEvent(String eventName) {
        // geben wir die Arbeit für DAO ein Event aus dem DB zu holen
        Event event = eventDAO.findEventByName(eventName);
        if (event != null) {
            this.eventsList.add(event);
        }
    }

    @Override
    public ArrayList<Event> getAllEvents() {
        eventsList = eventDAO.getAllEvents();
        return eventsList;

        /*
        Date date1 = new Date();
        Event event1 = new Event();
        event1.setVenue("Passau");
        event1.setDate(date1);

        Date date2 = new Date();
        Event event2 = new Event();
        event2.setVenue("Passau");
        event2.setDate(date2);

        Date date3 = new Date();
        Event event3 = new Event();
        event3.setVenue("Passau");
        event3.setDate(date3);

        ArrayList<Event> events = new ArrayList<>();

        events.add(event1);
        events.add(event2);
        events.add(event3);

        return events;*/

    }

    public ArrayList<Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(ArrayList<Event> eventsList) {
        this.eventsList = eventsList;
    }

    public EventDAO getEventDAO() {
        return eventDAO;
    }
}
