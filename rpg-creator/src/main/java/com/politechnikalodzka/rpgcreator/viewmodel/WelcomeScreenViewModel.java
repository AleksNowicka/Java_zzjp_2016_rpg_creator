package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.view.LogInView;

/**
 * Created by aleks on 15.08.16.
 */
public class WelcomeScreenViewModel extends BaseViewModel {

    private LogInView logInView;

    @Override
    public void setupNewFrame(String title){
        logInView = new LogInView(title);
    }

    public LogInView getLogInView() { return logInView; }

}
