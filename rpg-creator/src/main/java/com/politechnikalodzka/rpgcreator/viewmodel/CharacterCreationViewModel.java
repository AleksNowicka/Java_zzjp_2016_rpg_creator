package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 * Created by aleks on 19.08.16. Modyficate by lbary
 */
public class CharacterCreationViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;

    public CharacterCreationViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
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
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictrues.OUTFIT).size()];
        int counter = 0;
        for (Picture picure : super.getPictures().getPictureByType(TypeOfPictrues.OUTFIT)) {
            list[counter] = picure.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getHairList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictrues.HAIR).size()];
        int counter = 0;
        for (Picture picure : super.getPictures().getPictureByType(TypeOfPictrues.HAIR)) {
            list[counter] = picure.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getEyesList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictrues.EYES).size()];
        int counter = 0;
        for (Picture picure : super.getPictures().getPictureByType(TypeOfPictrues.EYES)) {
            list[counter] = picure.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getHatList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictrues.HAT).size()];
        int counter = 0;
        for (Picture picure : super.getPictures().getPictureByType(TypeOfPictrues.HAT)) {
            list[counter] = picure.getID();
            counter += 1;
        }
        return list;
    }

    public Integer[] getAccessoriesList() {
        Integer[] list = new Integer[super.getPictures().getPictureByType(TypeOfPictrues.ACCESSORIES).size()];
        int counter = 0;
        for (Picture picure : super.getPictures().getPictureByType(TypeOfPictrues.ACCESSORIES)) {
            list[counter] = picure.getID();
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

    public NavigationView getNavigationView() {
        return navigationView;
    }

    public void setDefaultDrawList() {
        if (this.getHairList().length > 0
                && this.getAccessoriesList().length > 0
                && this.getEyesList().length > 0
                && this.getHatList().length > 0
                && this.getOutfitList().length > 0
                && this.getPictures().getPictureByType(TypeOfPictrues.BASE).size() > 0) {
            this.getPictures().choosePicture(this.getHairList()[0]);
            this.getPictures().choosePicture(this.getAccessoriesList()[0]);
            this.getPictures().choosePicture(this.getEyesList()[0]);
            this.getPictures().choosePicture(this.getHatList()[0]);
            this.getPictures().choosePicture(this.getOutfitList()[0]);
            this.getPictures().choosePicture(this.getPictures().getPictureByType(TypeOfPictrues.BASE).get(0).getID());
        }
    }
}
