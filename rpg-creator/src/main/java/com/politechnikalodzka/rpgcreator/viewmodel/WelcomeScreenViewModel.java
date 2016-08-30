package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.view.LogInView;
import com.politechnikalodzka.rpgcreator.view.WelcomeScreenView;

import java.sql.SQLException;

/**
 * Created by aleks on 15.08.16.
 */
public class WelcomeScreenViewModel extends BaseViewModel {

    private LogInView logInView;

    public WelcomeScreenViewModel(String title) throws SQLException, ClassNotFoundException {
        logInView = new LogInView(title);
    }

    public LogInView getLogInView() {
        return logInView;
    }
}
