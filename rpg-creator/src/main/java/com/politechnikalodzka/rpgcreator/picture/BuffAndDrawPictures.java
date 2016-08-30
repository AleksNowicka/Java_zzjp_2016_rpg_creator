package com.politechnikalodzka.rpgcreator.picture;

import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author lbary
 */
public class BuffAndDrawPictures extends JPanel {

    private BufferedImage image;

    public BuffAndDrawPictures(Picture picture) {
        super();

        File imageFile = new File(picture.getURL());
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //TODO Obmyœliæ lub dogadaæ z dziewczynami jakie wspó³rzêdne
        g2d.drawImage(image, 0, 0, this);
    }

}
