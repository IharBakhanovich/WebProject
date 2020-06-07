package EventSystemGroup30.persistance;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static EventSystemGroup30.persistance.Event.COLUMN_EVENT_NAME;

@Repository
@Transactional
public class EventDAO {

    @PersistenceContext // das Container schaut in persistence.xml, ließt die Einstellungen aus, und erzeugt ein EntitzManager Objekt
    EntityManager entityManager;

    public void persist(Event event) {
        entityManager.persist(event);
    }

    //ein Beispiel der Query

    public Event findEventByName(String enteredEventName) {
        //SELECT * FROM event WHERE eventName = enteredEventName;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder(); // hilft ein Query zu erzeugen
        CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class); // auf velche Tabelle es geht

        Root<Event> fromTableEvent = query.from(Event.class);
        Path<Object> columnEventName = fromTableEvent.get(COLUMN_EVENT_NAME); //die Spalte die wir ansprechen wollen

        query.select(fromTableEvent);
        query.where(criteriaBuilder.equal(columnEventName, enteredEventName));

        //Typisierung: damit wir das Ergebniss holen können
        TypedQuery<Event> typedQuery = entityManager.createQuery(query);

        //Ausführung des Queries
        List<Event> resultList = typedQuery.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } else {
            return resultList.get(0); //geben erste Event
        }
        // return null; // einfach um Fehler zu beheben
    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> allEvents = new ArrayList<>();
        //SELECT * FROM event
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Event> query = criteriaBuilder.createQuery(Event.class); // auf velche Tabelle es geht

        Root<Event> fromTableEvent = query.from(Event.class);
        // Path<Object> columnEventName = fromTableEvent.get(COLUMN_EVENT_NAME);

        query.select(fromTableEvent);

        //Typisierung: damit wir das Ergebniss holen können
        TypedQuery<Event> typedQuery = entityManager.createQuery(query);
        // Execute query
        ArrayList<Event> resultList = (ArrayList<Event>) typedQuery.getResultList();

        //Ausführung des Queries

            if (resultList.isEmpty()) {
                System.out.println("Database is empty");
                Event event1 = new Event();
                event1.setVenue("Minsk");
                allEvents.add(event1);
            } else {
                allEvents = resultList;
            }

        return allEvents;
    }
}
