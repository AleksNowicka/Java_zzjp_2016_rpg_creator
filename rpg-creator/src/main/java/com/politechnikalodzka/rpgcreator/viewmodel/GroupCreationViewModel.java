package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;

/**
 * Created by aleks on 19.08.16.
 */
public class GroupCreationViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;

    public GroupCreationViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
    }

    public void saveNewGroup(Group newGroupToSave) throws SQLException, ClassNotFoundException {
        newGroupToSave.setGroupOwnerId(user.getId());
        newGroupToSave.saveAsNewGroup();
        user.retriveUsersGroupsWithTheirCharacters();
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
}
