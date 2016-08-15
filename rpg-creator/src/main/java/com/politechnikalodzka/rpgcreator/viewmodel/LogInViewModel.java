package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.MainView;

import java.sql.SQLException;

/**
 * Created by aleks on 15.08.16.
 */
public class LogInViewModel extends BaseViewModel {

    private MainView mainView;

    private User currentUser;

    @Override
    public void setupNewFrame(String title) {
        mainView = new MainView(title);
    }

    public boolean authenticateAndGetUser(String nick, String password) throws SQLException, ClassNotFoundException {
        currentUser = new User();
        if(!currentUser.authenticateAndGetData(nick, password)){
            return false;
        }
        currentUser.getUsersGroupsWithTheirCharacters();
        return true;
    }

    public MainView getMainView() { return mainView; }

}
