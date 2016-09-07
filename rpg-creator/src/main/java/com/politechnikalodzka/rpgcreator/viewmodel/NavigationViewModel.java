package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.enums.ViewModeEnum;
import com.politechnikalodzka.rpgcreator.view.*;

import java.sql.SQLException;

/**
 * Created by aleks on 19.08.16.
 */
public class NavigationViewModel extends BaseViewModel {

    private EditProfileView editProfileView;
    private CharacterCreationView characterCreationView;
    private EditExistingCharactersView editExistingCharactersView;
    private GroupCreationView groupCreationView;
    private EditExistingGroupsView editExistingGroupsView;
    private LogInView logInView;

    private User user;

    public NavigationViewModel(String title) throws SQLException, ClassNotFoundException {
        editProfileView = new EditProfileView(title);
        characterCreationView = new CharacterCreationView(title, ViewModeEnum.CREATE);
        editExistingCharactersView = new EditExistingCharactersView(title);
        groupCreationView = new GroupCreationView(title, ViewModeEnum.CREATE);
        editExistingGroupsView = new EditExistingGroupsView(title);
        logInView = new LogInView(title);
        user = User.getInstance();
        user.updateData();
    }

    public void logOut(){
        user.clearUser();
    }

    public String getUserNick() {
        return user.getNick();
    }

    public EditProfileView getEditProfileView() {
        return editProfileView;
    }

    public CharacterCreationView getCharacterCreationView() {
        return characterCreationView;
    }

    public EditExistingCharactersView getEditExistingCharactersView() {
        return editExistingCharactersView;
    }

    public GroupCreationView getGroupCreationView() {
        return groupCreationView;
    }

    public EditExistingGroupsView getEditExistingGroupsView() {
        return editExistingGroupsView;
    }

    public LogInView getLogInView() {
        return logInView;
    }
}
