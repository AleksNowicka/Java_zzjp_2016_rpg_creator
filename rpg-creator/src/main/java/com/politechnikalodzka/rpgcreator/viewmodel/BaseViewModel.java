package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.view.MainView;

import javax.swing.*;

/**
 * Created by aleks on 15.08.16.
 */
public abstract class BaseViewModel {

    public abstract void setupNewFrame(String title);

    public void switchFrames(JFrame actualFrame, JFrame nextFrame){
        actualFrame.dispose();
        nextFrame.setVisible(true);
    }

}
