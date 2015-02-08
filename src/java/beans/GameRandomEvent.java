package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * @author Karolain
 */
@Entity
@Table(name="randomEvents")
public class GameRandomEvent implements Serializable {
    @Id
    private Integer id;
    @OneToOne
    private GameEvent eventId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GameEvent getEventId() {
        return eventId;
    }

    public void setEventId(GameEvent eventId) {
        this.eventId = eventId;
    }
}
