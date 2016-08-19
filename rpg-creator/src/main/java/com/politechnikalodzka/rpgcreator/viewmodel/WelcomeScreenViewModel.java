package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.view.LogInView;
import com.politechnikalodzka.rpgcreator.view.WelcomeScreenView;

import javax.swing.*;

/**
 * Created by aleks on 15.08.16.
 */
public class WelcomeScreenViewModel extends BaseViewModel {

    private LogInView logInView;

    public WelcomeScreenViewModel(String title){
        logInView = new LogInView(title);
    }

    public LogInView getLogInView() { return logInView; }

}
