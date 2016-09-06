package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Character;
import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aleks on 19.08.16.
 */
public class EditExistingGroupsViewModel extends BaseViewModel{

    private NavigationView navigationView;

    private User user;

    public EditExistingGroupsViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
    }

    public String[] getUserGroupsNames(){
        List<Group> userGroups = user.getUserGroups();
        String[] userGroupsNames = new String[userGroups.size()];
        int counter = 0;
        for(Group group : userGroups){
            userGroupsNames[counter] = group.getName();
            counter += 1;
        }
        return userGroupsNames;
    }

    public String[] getUserGroupCharactersNames(String groupName){
        int groupId = -1;
        List<Character> userGroupCharacters = user.getUserCharacters();
        String[] userGroupCharactersNames = new String[userGroupCharacters.size()];

        for(Group group : user.getUserGroups()){
            if(group.getName().equals(groupName)){
                groupId = group.getId();
            }
        }
        if(groupId == -1){
            return userGroupCharactersNames;
        }
        int counter = 0;
        for(Character character : userGroupCharacters){
            if(character.getGroupId() == groupId){
                userGroupCharactersNames[counter] = character.getName();
                counter += 1;
            }
        }
        return userGroupCharactersNames;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

}
