package EventSystemGroup30;

import EventSystemGroup30.persistance.Event;
import EventSystemGroup30.model.Events;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class EventController {

    private static final Events events = new Events();

    // die Name des Templates leitet an Springframework weiter (hier "events")
    // und Springframework wird die HtmlSeite zusammenbasteln
    @GetMapping("/events")
    public String getEvents(Model model) {
        // Model ist eine Datenklasse wo wir Werte reinsetzen können und dann in freemarkerTemplate benutzen können
        events.setEventsList(events.getAllEvents());
        if (events.getEventsList() == null) {
            Date date1 = new Date();
            Event event1 = new Event();
            event1.setVenue("the List was empty");
            event1.setDate(date1);
            events.getEventsList().add(event1);
        }
        model.addAttribute("events", events.getEventsList());
        return "events";
    }
    @GetMapping("/event/{id}")
    public String getEvent(
            Model model,
            @PathVariable long id // zeigt auf die variable, die verglichen werden muss
    ) {
        Event event = null;
        for (Event oneEvent: events.getAllEvents()
             ) {
            if (oneEvent != null && oneEvent.getId() == id) {
                event = oneEvent;
                break;
            }

        }
        model.addAttribute("event", event); //übergeben dem Model unseres Event
        return "event";
    }

    @GetMapping("/events/create")
    public String createEvent(
            Model model
    ) {
        return "createEvent";
    }

    //für das Speichern die Daten
    @PostMapping("/events/create")
    public String submitEvent(
            Model model,
            String eventVenue,
            String eventName
    ) {
        Date date = new Date();
        Event createdEvent = new Event();
        createdEvent.setVenue(eventVenue);
        createdEvent.setDate(date);
        createdEvent.setEventName(eventName);
        events.getEventDAO().persist(createdEvent);
        //events.getAllEvents().add(createdEvent); // muss man in DB zu speichern
        return getEvents(model);
    }


}
