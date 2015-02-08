package beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @author Karolain
 */
@Entity
@Table(name="visitedEvents")
public class GameVisitedEvent implements Serializable {
    @EmbeddedId
    private GameVisitedEventsId id;
    @ManyToOne
    @JoinColumn(name="characterId")
    private GameCharacter characterId;
    @ManyToOne
    @JoinColumn(name="eventId")
    private GameEvent eventId;

    public GameVisitedEventsId getId() {
        return id;
    }

    public void setId(GameVisitedEventsId id) {
        this.id = id;
    }

    public GameCharacter getCharacterId() {
        return characterId;
    }

    public void setCharacterId(GameCharacter characterId) {
        this.characterId = characterId;
        if(this.id == null){
            this.id = new GameVisitedEventsId();
        }
        this.id.characterId = characterId.getId(); // JPA uses this for persisting
    }

    public GameEvent getEventId() {
        return eventId;
    }

    public void setEventId(GameEvent eventId) {
        this.eventId = eventId;
        if(this.id == null){
            this.id = new GameVisitedEventsId();
        }
        this.id.eventId = eventId.getId(); // JPA uses this for persisting
    }

}
@Embeddable
class GameVisitedEventsId implements Serializable {
    @Column(insertable = false, updatable = false)
    Integer characterId;
    @Column(insertable = false, updatable = false)
    Integer eventId;
}