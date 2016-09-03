package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.utils.Pictures;
import javax.swing.*;

/**
 * Created by aleks on 15.08.16.
 */
public abstract class BaseViewModel {
    
    private final Pictures pictures = new Pictures();

    public void switchFrames(JFrame actualFrame, JFrame nextFrame){
        actualFrame.dispose();
        nextFrame.setVisible(true);
    }
    
    public Pictures getPictures() {
        return pictures;
    }

}
