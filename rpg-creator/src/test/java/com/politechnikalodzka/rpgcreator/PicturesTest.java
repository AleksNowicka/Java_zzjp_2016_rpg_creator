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
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 10, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, "www", 11, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAIR, "ddd", 12, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 13, Gender.MALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "fff", 14, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 15, Gender.MALE);
        assertEquals(16, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 16, Gender.MALE);
        assertEquals(16, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "qwe", 17, Gender.MALE);
        assertEquals(17, instance.getAllPicture().size());
    }

    /**
     * Test of choosePicture method, of class ManagePictures.
     */
    @Test
    public void testChoosePicture() {
        System.out.println("choosePicture");
        Pictures instance = new Pictures();
        instance.addPictures(TypeOfPictrues.HAIR, "ccc", 18, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, "ddd", 19, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 20, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 21, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, "hhh", 22, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, "iii", 23, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, "kkk", 24, Gender.MALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "qwe", 25, Gender.MALE);
        try {
            assertEquals(24, instance.getPictrueToDraw().get(0).getID());
            assertEquals(18, instance.getPictrueToDraw().get(1).getID());
            assertEquals(22, instance.getPictrueToDraw().get(2).getID());
            assertEquals(23, instance.getPictrueToDraw().get(3).getID());
            assertEquals(25, instance.getPictrueToDraw().get(4).getID());
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
            assertEquals("D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\f.png", instance.getPictrueToDraw().get(2).getURL());
            instance.choosePicture(6);
            assertEquals("D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\c.png", instance.getPictrueToDraw().get(1).getURL());
            instance.choosePicture(8);
            assertEquals("D:\\OneDrive\\Dokumenty\\workspace\\ZZPJ\\Java_zzjp_2016_rpg_creator\\rpg-creator\\resources\\i.png", instance.getPictrueToDraw().get(3).getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
