package com.politechnikalodzka.rpgcreator.viewmodel;

import javax.swing.*;

/**
 * Created by aleks on 15.08.16.
 */
public abstract class BaseViewModel {

    public void switchFrames(JFrame actualFrame, JFrame nextFrame){
        actualFrame.dispose();
        nextFrame.setVisible(true);
    }

}
