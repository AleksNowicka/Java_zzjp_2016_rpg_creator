package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.utils.Pictures;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by aleks on 15.08.16.
 */
public abstract class BaseViewModel {
    
    private Pictures pictures = Pictures.getInstance();
    
    public void switchFrames(JFrame actualFrame, JFrame nextFrame) {
        actualFrame.dispose();
        nextFrame.setVisible(true);
    }
    
    public Pictures getPictures() {
        return pictures;
    }
    
    public void drawCharacter(JFrame actualFrame, List<JLabel> characterViewPanels, int x, int y) {
        BufferedImage bi;
        int counter = 0;
        File file;
        
        try {
            for (Picture p : pictures.getPictrueToDraw()) {
                characterViewPanels.add(new JLabel());
                characterViewPanels.get(counter).setBounds(x, y, 230, 396);
                actualFrame.getContentPane().add(characterViewPanels.get(counter));
                file = new File(p.getURL());
                bi = ImageIO.read(file);
                characterViewPanels.get(counter).setIcon(new ImageIcon(bi));
                counter++;
            }
        } catch (Exception ex) {
            Logger.getLogger(BaseViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cleanCharacter(List<JLabel> characterViewPanels) {
        for (JLabel panel : characterViewPanels) {
            panel.setIcon(null);
        }
    }
    
    public void drawGroupIcon(JLabel icon, Group currentGroup) {
        BufferedImage bi;
        File file;
        
        try {
            if (!currentGroup.getGroupIcon().equals(null)) {
                file = new File(currentGroup.getGroupIcon());
                bi = ImageIO.read(file);
                icon.setIcon(new ImageIcon(bi));
            }
        } catch (Exception ex) {
            Logger.getLogger(BaseViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawUserIcon(JLabel icon, User currentUser) {
        BufferedImage bi;
        File file;
        
        try {
            if (currentUser != null && !currentUser.getUserIcon().equals(null)) {
                file = new File(currentUser.getUserIcon());
                bi = ImageIO.read(file);
                icon.setIcon(new ImageIcon(bi));
            }
            
        } catch (Exception ex) {
            Logger.getLogger(BaseViewModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
