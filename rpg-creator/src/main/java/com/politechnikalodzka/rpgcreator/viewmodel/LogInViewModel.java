package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.MainView;

import java.sql.SQLException;

/**
 * Created by aleks on 15.08.16.
 */
public class LogInViewModel extends BaseViewModel {

    private MainView mainView;

    private User user;

    public LogInViewModel(String title) throws SQLException, ClassNotFoundException {
        mainView = new MainView(title);
        user = User.getInstance();
    }

    public boolean checkGivenDataAndLogIn(String nick, String password) throws SQLException, ClassNotFoundException {
        if(user.authenticateAndGetData(nick, password)){
            user.getUsersGroupsWithTheirCharacters();
            return true;
        }
        return false;
    }

    public MainView getMainView() {
        return mainView;
    }
}
