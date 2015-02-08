package service;

import beans.GameActionEvent;
import beans.GameCharacter;
import beans.GameEvent;
import beans.GameVisitedEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
 * @author Karolain
 */
public class DatabaseAccessorService {
    private final EntityManagerFactory factory;

    public DatabaseAccessorService() {
        factory = Persistence.createEntityManagerFactory("GamePU");

    }
    public void createNewCharacter(GameCharacter character) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(character);
        em.getTransaction().commit();
        em.close();
    }
    public GameCharacter getCharacterById(Integer id){
        EntityManager em = factory.createEntityManager();
        TypedQuery<GameCharacter> q = em.createQuery("from GameCharacter t where t.id = :id", GameCharacter.class);
        q.setParameter("id", id);
        GameCharacter ch;
        if (q.getResultList() != null && q.getResultList().size() == 1) {
            ch = q.getResultList().get(0);
        } else {
            ch = null;
        }
        em.close();
        return ch;
    }
    public void updateCharacter(GameCharacter ch){
        EntityManager em = factory.createEntityManager();
        GameCharacter character = em.find(GameCharacter.class, ch.getId());
        em.getTransaction().begin();
        character.setCharm(ch.getCharm());
        character.setMight(ch.getMight());
        character.setEndurance(ch.getEndurance());
        character.setFinesse(ch.getFinesse());
        character.setMind(ch.getMind());
        character.setSpirit(ch.getSpirit());
        character.setGold(ch.getGold());
        em.getTransaction().commit();
        em.close();
    }
    public List<GameEvent> getActionEvents(){
        EntityManager em = factory.createEntityManager();
        TypedQuery<GameActionEvent> q = em.createQuery("from GameActionEvent t", GameActionEvent.class);
        List<GameActionEvent> actionEvents = q.getResultList();
        List<GameEvent> events = new ArrayList<>();
        for (GameActionEvent e : actionEvents) { // Extract the actual events from actionEvents
            events.add(e.getEventId());
        }
        em.close();
        return events;
    }
    public GameEvent getEventById(Integer eventId){
        EntityManager em = factory.createEntityManager();
        GameEvent event = em.find(GameEvent.class, eventId);
        em.close();
        return event;
    }
    public void addNewVisitedEvent(GameEvent eventId, GameCharacter characterId){
        EntityManager em = factory.createEntityManager();
        GameVisitedEvent visitedEvent = new GameVisitedEvent();
        visitedEvent.setCharacterId(characterId);
        visitedEvent.setEventId(eventId);
        em.getTransaction().begin();
        em.merge(visitedEvent);
        em.getTransaction().commit();
        em.close();
    }
}
