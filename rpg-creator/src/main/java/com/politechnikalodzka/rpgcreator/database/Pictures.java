package com.politechnikalodzka.rpgcreator.database;

import com.politechnikalodzka.rpgcreator.database.BaseDataBaseEntity;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.picture.factory.PictureFactory;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Factory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbary
 */
public class Pictures extends BaseDataBaseEntity{
    
    private static Pictures instance = null;

    private List<Picture> pictrueToDraw;
    private List<Picture> allPicture;
    private Factory pictrueFactory = new PictureFactory();
    private Gender gender = Gender.MALE; //Default

    protected Pictures() throws ClassNotFoundException, SQLException {
        //initDataBaseAndQueryBuilder("Pictures"); TODO Nie wiem jak to dzia³a wiêc na razie wykomentuje
        this.pictrueToDraw = new ArrayList();
        for (int i = 0; i < 6; i++) {
            pictrueToDraw.add(null);
        }
        this.allPicture = new ArrayList();
    }
    
    public Pictures(int a) { //Konstruktor Testowy - Bêdzie trzeba jakoœ to zast¹piæ ale jeszcze nie wiem jak
        this.pictrueToDraw = new ArrayList();
        for (int i = 0; i < 6; i++) {
            pictrueToDraw.add(null);
        }
        this.allPicture = new ArrayList();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public static Pictures getInstance() throws ClassNotFoundException, SQLException {
        if(instance == null) {
            instance = new Pictures();
        }
        return instance;
    }

    public List<Picture> getPictrueToDraw() {
        return pictrueToDraw;
    }

    public List<Picture> getAllPicture() {
        return allPicture;
    }

    public List<Picture> getPictureByType(TypeOfPictrues type) {
        List<Picture> pictrueByPriority = new ArrayList();

        for (Picture p : allPicture) {
            if (p.getGender().equals(gender) && p.getType().equals(type)) {
                pictrueByPriority.add(p);
            }
        }

        return pictrueByPriority;
    }

    public void addPictures(TypeOfPictrues type, String url, int id) {
        boolean isNotContain = true;
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getURL().equals(url)) {
                isNotContain = false;
            }
        }

        if (isNotContain) {
            allPicture.add(pictrueFactory.addPicture(type, url, id));
        }
    }

    public void choosePicture(int ID) {
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getID() == ID) {
                this.addToDrawList(allPicture.get(i).getType(), allPicture.get(i));
            }
        }
    }

    private void addToDrawList(TypeOfPictrues type, Picture picture) {
        switch (type) {
            case HEAD:
                pictrueToDraw.set(0, picture);
                break;
            case OUTFIT:
                pictrueToDraw.set(1, picture);
                break;
            case HAIR:
                pictrueToDraw.set(2, picture);
                break;
            case EYES:
                pictrueToDraw.set(3, picture);
                break;
            case HAT:
                pictrueToDraw.set(4, picture);
                break;
            case ACCESSORIES:
                pictrueToDraw.set(5, picture);
                break;
        }
    }
}
