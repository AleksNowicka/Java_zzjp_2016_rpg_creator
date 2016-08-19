package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Character;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.enums.ViewModeEnum;
import com.politechnikalodzka.rpgcreator.view.*;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

/**
 * Created by aleks on 19.08.16.
 */
public class MainViewModel extends BaseViewModel {

    private EditProfileView editProfileView;
    private CharacterCreationView characterCreationView;
    private EditExistingCharactersView editExistingCharactersView;
    private GroupCreationView groupCreationView;
    private EditExistingGroupsView editExistingGroupsView;

    private User user;

    public MainViewModel(String title) throws SQLException, ClassNotFoundException {
        editProfileView = new EditProfileView(title);
        characterCreationView = new CharacterCreationView(title);
        editExistingCharactersView = new EditExistingCharactersView(title);
        groupCreationView = new GroupCreationView(title);
        editExistingGroupsView = new EditExistingGroupsView(title);
        user = User.getInstance();
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
}
