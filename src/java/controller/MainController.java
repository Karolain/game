package controller;

import beans.GameCharacter;
import beans.GameEvent;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DatabaseAccessorService;
import util.CharacterFactory;

/*
 * @author Karolain
 */
@Controller
public class MainController {
    @Autowired
    private DatabaseAccessorService dbService;
    
    @ModelAttribute("currentCharacter")
    public GameCharacter getCurrentCharacter(HttpSession session){
        Object characterIdObject = session.getAttribute("currentCharacterId");
        if (characterIdObject instanceof Integer) {
            return dbService.getCharacterById((Integer)characterIdObject);
        } else {
            return null;
        }
    }
    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        if (getCurrentCharacter(session)==null) { // Not logged in
            
        } else {    // Logged in
        }
        return "index";
    }
    @RequestMapping("newgame/")
    public String createNewGame(Model model){
        return "newgame";
    }
    @RequestMapping("startgame/")
    public String startNewGame(Model model, HttpSession session, @RequestParam(required = false) String character){
        GameCharacter newCharacter = CharacterFactory.newCharacter(character);
        dbService.createNewCharacter(newCharacter);
        session.setAttribute("currentCharacterId", newCharacter.getId());
        return "redirect:/";
    }
    @RequestMapping("getPossibleEvents")
    public String getPossibleEvents(Model model, HttpSession session, @RequestParam(required = true) String place){
        addPossibleEvents(model, place);
        return "eventSelector";
    }
    @RequestMapping("processEvent")
    public String processEvent(Model model, HttpSession session, @RequestParam(required = true) Integer eventId){
        processEventActions(model, session, eventId);
        return "eventResult"; 
    }
    @RequestMapping("characterAttributes")
    public String getCharacterAttributes(Model model, HttpSession session){
        return "characterAttributesTable";
    }

    private void addPossibleEvents(Model model, String place) {
        List<GameEvent> allActionEvents = dbService.getActionEvents();
        List<GameEvent> possibleEvents = new ArrayList<>();
        for (GameEvent event : allActionEvents) {
            if (place.replace('_', ' ').equals(event.getPlaceId().getName())){
                possibleEvents.add(event);
            }
        }
        model.addAttribute("possibleEvents", possibleEvents);
    }
    private void processEventActions(Model model, HttpSession session, Integer eventId){
        GameEvent event = dbService.getEventById(eventId);
        GameCharacter ch = getCurrentCharacter(session);
        
        ch.setCharm(ch.getCharm()+event.getCharm());
        ch.setMight(ch.getMight()+event.getMight());
        ch.setEndurance(ch.getEndurance()+event.getEndurance());
        ch.setFinesse(ch.getFinesse()+event.getFinesse());
        ch.setMind(ch.getMind()+event.getMind());
        ch.setSpirit(ch.getSpirit()+event.getSpirit());
        ch.setGold(ch.getGold()+event.getGold());
        
        
        dbService.addNewVisitedEvent(event, ch);
        dbService.updateCharacter(ch);
        model.addAttribute("selectedEvent", event);
    }
}
