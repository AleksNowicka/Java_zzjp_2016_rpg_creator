/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.database.Pictures;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import java.util.List;
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
        Pictures instance = new Pictures(1);
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 9);
        instance.addPictures(TypeOfPictrues.EYES, "www", 3);
        instance.addPictures(TypeOfPictrues.HAIR, "ddd", 4);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 5);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "fff", 6);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 7);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 3);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "qwe", 11);
        assertEquals(7, instance.getAllPicture().size());
    }

    /**
     * Test of choosePicture method, of class ManagePictures.
     */
    @Test
    public void testChoosePicture() {
        System.out.println("choosePicture");
        Pictures instance = new Pictures(1);
        instance.addPictures(TypeOfPictrues.HAIR, "ccc", 1);
        instance.addPictures(TypeOfPictrues.EYES, "ddd", 2);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 3);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 5);
        instance.addPictures(TypeOfPictrues.EYES, "hhh", 6);
        instance.addPictures(TypeOfPictrues.HAT, "iii", 7);
        instance.addPictures(TypeOfPictrues.OUTFIT, "kkk", 9);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, "qwe", 10);
        assertEquals(null, instance.getPictrueToDraw().get(0));
        assertEquals(null, instance.getPictrueToDraw().get(1));
        assertEquals(null, instance.getPictrueToDraw().get(2));
        assertEquals(null, instance.getPictrueToDraw().get(3));
        assertEquals(null, instance.getPictrueToDraw().get(4));
        instance.choosePicture(1);
        instance.choosePicture(2);
        instance.choosePicture(3);
        instance.choosePicture(4);
        instance.choosePicture(5);
        instance.choosePicture(10);
        assertEquals("ddd", instance.getPictrueToDraw().get(2).getURL());
        instance.choosePicture(6);
        assertEquals("ccc", instance.getPictrueToDraw().get(1).getURL());
        instance.choosePicture(8);
        assertEquals("eee", instance.getPictrueToDraw().get(3).getURL());
    }
    
}
