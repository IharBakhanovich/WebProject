package EventSystemGroup30.persistance;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class DataGenerator {

    @Resource //das Konteiner kümmer darum ob eine existierende Instanz benutzt wird oder eine neue Instanz erzeugt wird
    EventDAO eventDAO;


    @PostConstruct
    public void setupData() {
        Date date1 = new Date();
        Event event1 = new Event();
        event1.setVenue("Passau");
        event1.setDate(date1);
        eventDAO.persist(event1);

        Date date2 = new Date();
        Event event2 = new Event();
        event2.setVenue("Passau");
        event2.setDate(date2);
        eventDAO.persist(event2);

        Date date3 = new Date();
        Event event3 = new Event();
        event3.setVenue("Passau");
        event3.setDate(date3);
        eventDAO.persist(event3);
    }
}
