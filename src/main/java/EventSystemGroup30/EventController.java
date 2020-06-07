package EventSystemGroup30;

import EventSystemGroup30.persistance.Event;
import EventSystemGroup30.model.Events;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class EventController {

    @Resource
    private Events events;

    // die Name des Templates leitet an Springframework weiter (hier "events")
    // und Springframework wird die HtmlSeite zusammenbasteln
    @GetMapping("/events")
    public String getEvents(Model model) {
        // Model ist eine Datenklasse wo wir Werte reinsetzen können und dann in freemarkerTemplate benutzen können
        model.addAttribute("events", events.getAllEvents());
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
        events.persist(createdEvent);
        //events.getAllEvents().add(createdEvent); // muss man in DB zu speichern
        return getEvents(model);
    }


}
