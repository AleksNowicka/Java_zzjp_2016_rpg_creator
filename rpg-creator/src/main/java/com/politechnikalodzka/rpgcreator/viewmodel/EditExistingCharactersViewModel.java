package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.database.User;
import com.politechnikalodzka.rpgcreator.view.NavigationView;

import java.sql.SQLException;

/**
 * Created by aleks on 19.08.16.
 */
public class EditExistingCharactersViewModel extends BaseViewModel {

    private NavigationView navigationView;

    private User user;

    public EditExistingCharactersViewModel(String title) throws SQLException, ClassNotFoundException {
        navigationView = new NavigationView(title);
        user = User.getInstance();
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }
}
