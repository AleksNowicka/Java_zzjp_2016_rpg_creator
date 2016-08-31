package com.politechnikalodzka.rpgcreator.viewmodel;


import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;

/**
 * Created by aleks on 19.08.16.
 */
public class CharacterCreationViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;

    public CharacterCreationViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
    }

    public String[] getGroupsNames(){
        String[] groupsNames = new String[user.getUserGroups().size()];
        int counter = 0;
        for(Group group : user.getUserGroups()){
            groupsNames[counter] = group.getName();
            counter += 1;
        }
        return groupsNames;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
}
