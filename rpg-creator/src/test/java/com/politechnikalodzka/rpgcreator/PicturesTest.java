package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.utils.Pictures;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictures;
import com.politechnikalodzka.rpgcreator.database.Character;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lbary
 */
public class PicturesTest {

    public PicturesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPictures method, of class Pictures.
     */
    @Test
    public void testAddPictures() {
        System.out.println("addPictures");
        Pictures instance = Pictures.getInstance();
        instance.setAllPicture(new ArrayList());
        instance.addPictures(TypeOfPictures.HAIR, "bbb", 0, Gender.MALE);
        instance.addPictures(TypeOfPictures.EYES, "www", 1, Gender.MALE);
        instance.addPictures(TypeOfPictures.HAIR, "ddd", 2, Gender.MALE);
        instance.addPictures(TypeOfPictures.HAT, "eee", 3, Gender.MALE);
        instance.addPictures(TypeOfPictures.ACCESSORIES, "fff", 4, Gender.MALE);
        instance.addPictures(TypeOfPictures.OUTFIT, "ggg", 5, Gender.MALE);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictures.HAIR, "bbb", 6, Gender.MALE);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictures.ACCESSORIES, "qwe", 7, Gender.MALE);
        assertEquals(7, instance.getAllPicture().size());
    }

    /**
     * Test of choosePicture method, of class ManagePictures.
     */
    @Test
    public void testChoosePicture() {
        System.out.println("choosePicture");
        Pictures instance = Pictures.getInstance();

        instance.setAllPicture(new ArrayList());
        instance.setPictureToDraw();

        instance.addPictures(TypeOfPictures.HAIR, "aaa", 0, Gender.MALE);
        instance.addPictures(TypeOfPictures.EYES, "bbb", 1, Gender.MALE);
        instance.addPictures(TypeOfPictures.HAT, "ccc", 2, Gender.MALE);
        instance.addPictures(TypeOfPictures.OUTFIT, "ddd", 3, Gender.MALE);
        instance.addPictures(TypeOfPictures.ACCESSORIES, "eee", 4, Gender.MALE);
        instance.addPictures(TypeOfPictures.BASE, "fff", 5, Gender.MALE);

        assertEquals(null, instance.getPictureToDraw().get(0));
        assertEquals(null, instance.getPictureToDraw().get(1));
        assertEquals(null, instance.getPictureToDraw().get(2));
        assertEquals(null, instance.getPictureToDraw().get(3));
        assertEquals(null, instance.getPictureToDraw().get(4));
        assertEquals(null, instance.getPictureToDraw().get(5));

        instance.choosePicture(0);
        instance.choosePicture(1);
        instance.choosePicture(2);
        instance.choosePicture(3);
        instance.choosePicture(4);
        instance.choosePicture(5);

        assertEquals(4, instance.getPictureToDraw().get(0).getID());
        assertEquals(2, instance.getPictureToDraw().get(1).getID());
        assertEquals(1, instance.getPictureToDraw().get(2).getID());
        assertEquals(0, instance.getPictureToDraw().get(3).getID());
        assertEquals(3, instance.getPictureToDraw().get(4).getID());
        assertEquals(5, instance.getPictureToDraw().get(5).getID());

    }

    @Test
    public void testSetCurrentCharacter() {
        System.out.println("setCurrentCharacter");
        Pictures instance = Pictures.getInstance();
        instance.setAllPicture(new ArrayList());

        instance.addPictures(TypeOfPictures.ACCESSORIES, "aaa", 0, Gender.MALE);
        instance.addPictures(TypeOfPictures.BASE, "bbb", 1, Gender.MALE);
        instance.addPictures(TypeOfPictures.EYES, "ccc", 2, Gender.MALE);
        instance.addPictures(TypeOfPictures.HAIR, "ddd", 3, Gender.MALE);
        instance.addPictures(TypeOfPictures.HAT, "eee", 4, Gender.MALE);
        instance.addPictures(TypeOfPictures.OUTFIT, "fff", 5, Gender.MALE);

        instance.addPictures(TypeOfPictures.ACCESSORIES, "ggg", 6, Gender.FEMALE);
        instance.addPictures(TypeOfPictures.BASE, "hhh", 7, Gender.FEMALE);
        instance.addPictures(TypeOfPictures.EYES, "iii", 8, Gender.FEMALE);
        instance.addPictures(TypeOfPictures.HAIR, "jjj", 9, Gender.FEMALE);
        instance.addPictures(TypeOfPictures.HAT, "kkk", 10, Gender.FEMALE);
        instance.addPictures(TypeOfPictures.OUTFIT, "lll", 11, Gender.FEMALE);

        Character characterMale = new Character(1.0);
        characterMale.setAccessoriesId(0);
        characterMale.setEyesId(2);
        characterMale.setHairId(3);
        characterMale.setHatId(4);
        characterMale.setOutfitId(5);
        characterMale.setGender(true);
        instance.setCurrentCharacter(characterMale);
        instance.choosePicture(1);
        assertEquals("MALE", instance.getGender().toString());
        assertEquals(0, instance.getPictureToDraw().get(0).getID());
        assertEquals(4, instance.getPictureToDraw().get(1).getID());
        assertEquals(2, instance.getPictureToDraw().get(2).getID());
        assertEquals(3, instance.getPictureToDraw().get(3).getID());
        assertEquals(5, instance.getPictureToDraw().get(4).getID());
        assertEquals(1, instance.getPictureToDraw().get(5).getID());

        Character characterFemale = new Character(2.0);
        characterFemale.setAccessoriesId(6);
        characterFemale.setEyesId(8);
        characterFemale.setHairId(9);
        characterFemale.setHatId(10);
        characterFemale.setOutfitId(11);
        characterFemale.setGender(false);
        instance.setCurrentCharacter(characterFemale);
        instance.choosePicture(7);
        assertEquals("FEMALE", instance.getGender().toString());
        assertEquals(6, instance.getPictureToDraw().get(0).getID());
        assertEquals(10, instance.getPictureToDraw().get(1).getID());
        assertEquals(8, instance.getPictureToDraw().get(2).getID());
        assertEquals(9, instance.getPictureToDraw().get(3).getID());
        assertEquals(11, instance.getPictureToDraw().get(4).getID());
        assertEquals(7, instance.getPictureToDraw().get(5).getID());
    }

}
