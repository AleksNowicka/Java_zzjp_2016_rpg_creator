package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleks on 19.08.16.
 */
public class GroupCreationViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;
    private Group editedGroup;

    public GroupCreationViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
        editedGroup = new Group();
    }

    public void saveNewGroup(Group newGroupToSave) throws SQLException, ClassNotFoundException {
        newGroupToSave.setGroupOwnerId(user.getId());
        newGroupToSave.saveAsNewGroup();
        user.retriveUsersGroupsWithTheirCharacters();
    }

    public void saveEditedGroup() throws SQLException, ClassNotFoundException {
        editedGroup.setGroupOwnerId(user.getId());
        editedGroup.saveAsEditedGroup();
        user.retriveUsersGroupsWithTheirCharacters();
    }

    public Group getEditedGroup() {
        return editedGroup;
    }

    public void setEditedGroup(Group editedGroup) {
        this.editedGroup = editedGroup;
    }

    public void setEditedGroupById(int groupId){
        List<Group> userGroups = user.getUserGroups();
        for(Group group : userGroups){
            if(group.getId() == groupId){
                editedGroup = group;
                return;
            }
        }
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
}
