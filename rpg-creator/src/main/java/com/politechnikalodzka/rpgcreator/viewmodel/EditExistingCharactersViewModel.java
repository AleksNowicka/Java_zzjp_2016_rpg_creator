package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Character;
import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.enums.ViewModeEnum;
import com.politechnikalodzka.rpgcreator.view.CharacterCreationView;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by aleks on 19.08.16.
 */
public class EditExistingCharactersViewModel extends BaseViewModel {

    private NavigationView navigationView;
    private CharacterCreationView characterCreationView;

    private User user;

    public EditExistingCharactersViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        characterCreationView = new CharacterCreationView(title, ViewModeEnum.EDIT);
        user = User.getInstance();
    }

    public void removeChosenCharacter(String characterName) throws SQLException, ClassNotFoundException {
        List<Character> userCharacters = user.getUserCharacters();
        for (Character character : userCharacters) {
            if (character.getName().equals(characterName)) {
                user.removeCharacter(character.getId());
                user.retrieveUsersGroupsWithTheirCharacters();
                return;
            }
        }
    }

    public String[] getAllUsersCharactersNames() {
        List<Character> characters = user.getUserCharacters();
        String[] charactersNames = new String[characters.size()];
        int counter = 0;
        for (Character character : characters) {
            charactersNames[counter] = character.getName();
            counter += 1;
        }
        return charactersNames;
    }

    public String getCharactersGroupName(String characterName) {
        int charactersGroupId = -1;
        Map<Integer, List<Character>> usersGroupsWithTheirCharacters = user.getUsersGroupsWithTheirCharacters();
        for (Integer groupId : usersGroupsWithTheirCharacters.keySet()) {
            for (Character character : usersGroupsWithTheirCharacters.get(groupId)) {
                if (character.getName().equals(characterName)) {
                    charactersGroupId = groupId;
                    break;
                }
            }
            if (charactersGroupId != -1) {
                break;
            }
        }
        if (charactersGroupId == -1) {
            return "-";
        }
        for (Group group : user.getUserGroups()) {
            if (group.getId() == charactersGroupId) {
                return group.getName();
            }
        }
        return "-";
    }

    public void setCharacterCreationViewCharacterToEdit(String characterName){
        List<Character> userCharacter = user.getUserCharacters();
        for(Character character : userCharacter){
            if(character.getName().equals(characterName)){
                characterCreationView.setCharacterToEdit(character);
                characterCreationView.setupEditedCharacterData();
            }
        }
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

    public Character getCharacterByName(String name) {
        List<Character> userCharacter = user.getUserCharacters();
        for(Character character : userCharacter){
            if(character.getName().equals(name)){
                return character;
            }
        }
        return null;
    }

    public CharacterCreationView getCharacterCreationView() { return characterCreationView; }
}
