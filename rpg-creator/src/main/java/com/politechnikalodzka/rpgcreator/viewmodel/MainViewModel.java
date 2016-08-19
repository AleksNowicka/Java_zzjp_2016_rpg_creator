package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.view.*;

import javax.swing.*;

/**
 * Created by aleks on 17.08.16.
 */
public class MainViewModel extends BaseViewModel {

    private CharacterCreationView characterCreationView;
    private EditExistingCharactersView editExistingCharactersView;
    private GroupCreationView groupCreationView;
    private EditExistingGroupsView editExistingGroupsView;
    private EditProfileView editProfileView;

    public MainViewModel(String title){
        characterCreationView = new CharacterCreationView(title);
        editExistingCharactersView = new EditExistingCharactersView(title);
        groupCreationView = new GroupCreationView(title);
        editExistingGroupsView = new EditExistingGroupsView(title);
        editProfileView = new EditProfileView(title);
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

    public EditProfileView getEditProfileView() {
        return editProfileView;
    }
}
