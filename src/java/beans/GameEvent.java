package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * @author Karolain
 */
@Entity
@Table(name="events")
public class GameEvent implements Serializable {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="placeId")
    private GamePlace placeId;
    private String name;
    private String description;
    private Boolean repeatable;
    private Integer might;
    private Integer endurance;
    private Integer finesse;
    private Integer charm;
    private Integer mind;
    private Integer spirit;
    private Integer gold;
    @ManyToOne
    @JoinColumn(name="id", insertable = false, updatable = false)
    private GameEvent dependsOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GamePlace getPlaceId() {
        return placeId;
    }

    public void setPlaceId(GamePlace placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        this.repeatable = repeatable;
    }

    public Integer getMight() {
        return might;
    }

    public void setMight(Integer might) {
        this.might = might;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    public Integer getFinesse() {
        return finesse;
    }

    public void setFinesse(Integer finesse) {
        this.finesse = finesse;
    }

    public Integer getCharm() {
        return charm;
    }

    public void setCharm(Integer charm) {
        this.charm = charm;
    }

    public Integer getMind() {
        return mind;
    }

    public void setMind(Integer mind) {
        this.mind = mind;
    }

    public Integer getSpirit() {
        return spirit;
    }

    public void setSpirit(Integer spirit) {
        this.spirit = spirit;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public GameEvent getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(GameEvent dependsOn) {
        this.dependsOn = dependsOn;
    }

    @Override
    public String toString() {
        return "GameEvents{" + "id=" + id + ", placeId=" + placeId + ", name=" + name + ", description=" + description + ", repeatable=" + repeatable + ", might=" + might + ", endurance=" + endurance + ", finesse=" + finesse + ", charm=" + charm + ", mind=" + mind + ", spirit=" + spirit + ", gold=" + gold + '}';
    }
    
}
