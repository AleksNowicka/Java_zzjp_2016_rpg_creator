/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.politechnikalodzka.rpgcreator.picture;

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
public class ManagePicturesTest {
    
    public ManagePicturesTest() {
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
     * Test of addPictures method, of class ManagePictures.
     */
    @Test
    public void testAddPictures() {
        System.out.println("addPictures");
        ManagePictures instance = new ManagePictures();
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 9);
        instance.addPictures(TypeOfPictrues.EYES, "www", 3);
        instance.addPictures(TypeOfPictrues.HAIR, "ddd", 4);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 5);
        instance.addPictures(TypeOfPictrues.HEAD, "fff", 6);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 7);
        assertEquals(6, instance.getAllPicture().size());
        instance.addPictures(TypeOfPictrues.HAIR, "bbb", 3);
        assertEquals(6, instance.getAllPicture().size());
    }

    /**
     * Test of choosePicture method, of class ManagePictures.
     */
    @Test
    public void testChoosePicture() {
        System.out.println("choosePicture");
        ManagePictures instance = new ManagePictures();
        instance.addPictures(TypeOfPictrues.HAIR, "ccc", 3);
        instance.addPictures(TypeOfPictrues.EYES, "ddd", 4);
        instance.addPictures(TypeOfPictrues.HAT, "eee", 5);
        instance.addPictures(TypeOfPictrues.HEAD, "fff", 6);
        instance.addPictures(TypeOfPictrues.OUTFIT, "ggg", 7);
        instance.addPictures(TypeOfPictrues.EYES, "hhh", 8);
        instance.addPictures(TypeOfPictrues.HAT, "iii", 9);
        instance.addPictures(TypeOfPictrues.HEAD, "jjj", 10);
        instance.addPictures(TypeOfPictrues.OUTFIT, "kkk", 11);
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
        instance.choosePicture(6);
        instance.choosePicture(7);
        assertEquals("ccc", instance.getPictrueToDraw().get(2).getURL());
        instance.choosePicture(10);
        assertEquals("jjj", instance.getPictrueToDraw().get(1).getURL());
        instance.choosePicture(11);
        assertEquals("ddd", instance.getPictrueToDraw().get(3).getURL());
    }
    
}
