package EventSystemGroup30.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * to develop the entity/Event of the System
 */
@Entity // können hier die Name der Tabelle im Datenbank schreiben
public class Event implements Serializable {
    public static final String COLUMN_EVENT_NAME = "eventName";
    public static final String COLUMN_EVENT_ID = "eventId";
    //private String id = UUID.randomUUID().toString(); für Tests
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_EVENT_ID, unique = true)
    private long id;
    private String venue;

    @Column(name = COLUMN_EVENT_NAME, unique = true) //so für jede Variable kann man machen
    private String eventName;
    private Type type;
    private Date date;
    private int likeIt = 0;
    private int dislikeIt = 0;
    private String weather;

    public Event() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public long getId() {
        return id;
    }

    public String getVenue() {
        return venue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public int getLikeIt() {
        return likeIt;
    }

    public void setLikeIt(int likeIt) {
        this.likeIt = likeIt;
    }

    public int getDislikeIt() {
        return dislikeIt;
    }

    public void setDislikeIt(int dislikeIt) {
        this.dislikeIt = dislikeIt;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
