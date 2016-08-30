package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;

/**
 * Created by aleks on 15.08.16.
 */
public class LogInViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;

    public LogInViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
    }

    public boolean checkGivenDataAndLogIn(String nick, String password) throws SQLException, ClassNotFoundException {
        if(user.authenticateAndGetData(nick, password)){
//            user.retriveUsersGroupsWithTheirCharacters();
            System.out.println(user.getNick());
            return true;
        }
        return false;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
}
