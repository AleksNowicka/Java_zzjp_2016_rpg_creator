package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Character;
import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictures;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleks on 19.08.16. Modyficate by lbary
 */
public class CharacterCreationViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;
    private Character editedCharacter;

    public CharacterCreationViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
        editedCharacter = new Character();
    }

    public void saveNewCharacter(Character newCharacterToSave) throws SQLException, ClassNotFoundException {
        newCharacterToSave.saveAsNewCharacter();
        user.retrieveUsersGroupsWithTheirCharacters();
    }

    public void saveAsEditedCharacter() throws SQLException, ClassNotFoundException {
        editedCharacter.saveAsEditedCharacter();
        user.retrieveUsersGroupsWithTheirCharacters();
    }

    public void setDefaultDrawList() {
        if (this.getHairList().length > 0
                && this.getAccessoriesList().length > 0
                && this.getEyesList().length > 0
                && this.getHatList().length > 0
                && this.getOutfitList().length > 0
                && this.getPictures().getPictureByType(TypeOfPictures.BASE).size() > 0) {
            this.getPictures().choosePicture(this.getHairList()[0]);
            this.getPictures().choosePicture(this.getAccessoriesList()[0]);
            this.getPictures().choosePicture(this.getEyesList()[0]);
            this.getPictures().choosePicture(this.getHatList()[0]);
            this.getPictures().choosePicture(this.getOutfitList()[0]);
            this.getPictures().choosePicture(this.getPictures().getPictureByType(TypeOfPictures.BASE).get(0).getID());
        }
    }

    public void setSpecificDrawList(){
        if (this.getHairList().length > 0
                && this.getAccessoriesList().length > 0
                && this.getEyesList().length > 0
                && this.getHatList().length > 0
                && this.getOutfitList().length > 0
                && this.getPictures().getPictureByType(TypeOfPictures.BASE).size() > 0) {
            this.getPictures().choosePicture(editedCharacter.getHairId());
            this.getPictures().choosePicture(editedCharacter.getAccessoriesId());
            this.getPictures().choosePicture(editedCharacter.getEyesId());
            this.getPictures().choosePicture(editedCharacter.getHatId());
            this.getPictures().choosePicture(editedCharacter.getOutfitId());
            this.getPictures().choosePicture(this.getPictures().getPictureByType(TypeOfPictures.BASE).get(0).getID());
        }
    }

    public Gender getEditedCharactersGender(){
        if(editedCharacter.getGender() == 'm'){
            return Gender.MALE;
        }
        return Gender.FEMALE;
    }

    public String[] getGroupsNames() {
        String[] groupsNames = new String[user.getUserGroups().size()];
        int counter = 0;
        for (Group group : user.getUserGroups()) {
            groupsNames[counter] = group.getName();
            counter += 1;
        }
        return groupsNames;
    }

    public Integer[] getOutfitList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictures.OUTFIT).size()];
        int counter = 0;
        for (Picture picture : super.getPictures().getPictureByType(TypeOfPictures.OUTFIT)) {
            list[counter] = picture.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getHairList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictures.HAIR).size()];
        int counter = 0;
        for (Picture picture : super.getPictures().getPictureByType(TypeOfPictures.HAIR)) {
            list[counter] = picture.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getEyesList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictures.EYES).size()];
        int counter = 0;
        for (Picture picture : super.getPictures().getPictureByType(TypeOfPictures.EYES)) {
            list[counter] = picture.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getHatList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictures.HAT).size()];
        int counter = 0;
        for (Picture picture : super.getPictures().getPictureByType(TypeOfPictures.HAT)) {
            list[counter] = picture.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getAccessoriesList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictures.ACCESSORIES).size()];
        int counter = 0;
        for (Picture picture : super.getPictures().getPictureByType(TypeOfPictures.ACCESSORIES)) {
            list[counter] = picture.getID();
            counter += 1;
        }
        return list;
    }

    public String[] getGenderList() {
        String[] genderList = new String[2];
        genderList[0] = Gender.MALE.toString();
        genderList[1] = Gender.FEMALE.toString();
        return genderList;
    }

    public int getGroupIdByName(String groupName){
        List<Group> userGroups = user.getUserGroups();
        for(Group group : userGroups){
            if(group.getName().equals(groupName)){
                return group.getId();
            }
        }
        return -1;
    }

    public String getGroupNameById(int groupId){
        List<Group> userGroups = user.getUserGroups();
        for(Group group : userGroups){
            if(group.getId() == groupId){
                return group.getName();
            }
        }
        return null;
    }

    public Character getEditedCharacter() {
        return editedCharacter;
    }
    public void setEditedCharacter(Character editedCharacter) {
        this.editedCharacter = editedCharacter;
    }
    public NavigationView getNavigationView() {
        return navigationView;
    }

}
