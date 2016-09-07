package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.Group;
import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleks on 19.08.16.
 */
public class EditProfileViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;

    public EditProfileViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
    }

    public void updateUserData(String nick, String password) throws SQLException {
        user.setNick(nick);
        user.setPassword(password);
        System.out.println(user.getNick() + " " + user.getPassword());
        user.saveAsEditedUser();
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
    public User getUser() {
        return user;
    }
}
