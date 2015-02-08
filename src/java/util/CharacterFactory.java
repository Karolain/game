package util;

import beans.GameCharacter;

/*
 * @author Karolain
 */

public class CharacterFactory {

    public static GameCharacter newCharacter(String character) {
        GameCharacter newCharacter = new GameCharacter();
        if(character.compareTo("fiona")==0){
            newCharacter.setName("Fiona");
            newCharacter.setDescription("");
            newCharacter.setRace("Human");
            newCharacter.setMight(0);
            newCharacter.setEndurance(0);
            newCharacter.setFinesse(0);
            newCharacter.setCharm(0);
            newCharacter.setMind(0);
            newCharacter.setSpirit(0);
            newCharacter.setGold(0);
        } else {
            // TODO: Other characters
        }
        return newCharacter;
    }
}
