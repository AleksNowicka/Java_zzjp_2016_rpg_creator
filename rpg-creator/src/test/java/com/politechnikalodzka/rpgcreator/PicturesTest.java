package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.utils.Pictures;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
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
        Pictures instance = new Pictures();
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 9, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, "www", 3, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAIR, "ddd", 4, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 5, Gender.MALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "fff", 6, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 7, Gender.MALE);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 3, Gender.MALE);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "qwe", 11, Gender.MALE);
        assertEquals(7, instance.getAllPicture().size());
    }

    /**
     * Test of choosePicture method, of class ManagePictures.
     */
    @Test
    public void testChoosePicture() {
        System.out.println("choosePicture");
        Pictures instance = new Pictures();
        instance.addPictures(TypeOfPictrues.HAIR, "ccc", 1, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, "ddd", 2, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 3, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 5, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, "hhh", 6, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, "iii", 7, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, "kkk", 9, Gender.MALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "qwe", 10, Gender.MALE);
        try {
            assertEquals(9, instance.getPictrueToDraw().get(0).getID());
            assertEquals(1, instance.getPictrueToDraw().get(1).getID());
            assertEquals(6, instance.getPictrueToDraw().get(2).getID());
            assertEquals(7, instance.getPictrueToDraw().get(3).getID());
            assertEquals(10, instance.getPictrueToDraw().get(4).getID());
        } catch (Exception e) {
            e.printStackTrace();
        }

        instance.choosePicture(1);
        instance.choosePicture(2);
        instance.choosePicture(3);
        instance.choosePicture(4);
        instance.choosePicture(5);
        instance.choosePicture(10);
        try {
            assertEquals("ddd", instance.getPictrueToDraw().get(2).getURL());
            instance.choosePicture(6);
            assertEquals("ccc", instance.getPictrueToDraw().get(1).getURL());
            instance.choosePicture(8);
            assertEquals("eee", instance.getPictrueToDraw().get(3).getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
