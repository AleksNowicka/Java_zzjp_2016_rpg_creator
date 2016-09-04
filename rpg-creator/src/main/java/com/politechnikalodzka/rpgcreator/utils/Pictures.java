package com.politechnikalodzka.rpgcreator.utils;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.picture.factory.PictureFactory;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Factory;
import com.politechnikalodzka.rpgcreator.database.Character;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbary
 */
public class Pictures {

    private List<Picture> pictrueToDraw;
    private List<Picture> allPicture;
    private Factory pictrueFactory = new PictureFactory();
    private Gender gender = Gender.MALE; //Default

    public Pictures() {
        this.pictrueToDraw = new ArrayList();
        for (int i = 0; i < 5; i++) {
            pictrueToDraw.add(null);
        }
        this.allPicture = new ArrayList();

        this.addPictures(TypeOfPictrues.EYES, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\a.png", 0, Gender.MALE);
        this.addPictures(TypeOfPictrues.ACCESSORIES, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\b.png", 1, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAIR, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\c.png", 2, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAT, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\d.png", 3, Gender.MALE);
        this.addPictures(TypeOfPictrues.OUTFIT, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\e.png", 4, Gender.MALE);
        this.addPictures(TypeOfPictrues.EYES, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\f.png", 5, Gender.MALE);
        this.addPictures(TypeOfPictrues.ACCESSORIES, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\g.png", 6, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAIR, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\h.png", 7, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAT, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\i.png", 8, Gender.MALE);
        this.addPictures(TypeOfPictrues.OUTFIT, "D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\j.png", 9, Gender.MALE);

    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Picture> getPictrueToDraw() {
        return pictrueToDraw;
    }

    public List<Picture> getAllPicture() {
        return allPicture;
    }

    public List<Picture> getPictureByType(TypeOfPictrues type) {
        List<Picture> pictrueByType = new ArrayList();

        for (Picture p : allPicture) {
            if (p.getGender().equals(gender) && p.getType().equals(type)) {
                pictrueByType.add(p);
            }
        }
        return pictrueByType;
    }

    public void addPictures(TypeOfPictrues type, String url, int id, Gender gender) {
        boolean isNotContain = true;
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getURL().equals(url)) {
                isNotContain = false;
            }
        }

        if (isNotContain) {
            allPicture.add(pictrueFactory.addPicture(type, url, id, gender));
            this.choosePicture(id);
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
            case OUTFIT:
                pictrueToDraw.set(0, picture);
                break;
            case HAIR:
                pictrueToDraw.set(1, picture);
                break;
            case EYES:
                pictrueToDraw.set(2, picture);
                break;
            case HAT:
                pictrueToDraw.set(3, picture);
                break;
            case ACCESSORIES:
                pictrueToDraw.set(4, picture);
                break;
        }
    }

    public void setCurrentCharacter(Character character) { // Ta metoda pobiera dane na temat obrazk�w dla aktualnie wybranego Character'a
        this.choosePicture(character.getAccessoriesId());
        this.choosePicture(character.getEyesId());
        this.choosePicture(character.getGroupId());
        this.choosePicture(character.getHairId());
        this.choosePicture(character.getHatId());
        this.choosePicture(character.getOutfitId());
        this.setGender(Gender.valueOf(String.valueOf(character.getGender())));
        //this.setGender(character.getGender()) // ta linijka b�dzie prawid�owa po dokonaniu zmian w Character
    }
}
