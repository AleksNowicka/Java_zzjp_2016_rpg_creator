package com.politechnikalodzka.rpgcreator.viewmodel;

import com.politechnikalodzka.rpgcreator.view.MainView;

import javax.swing.*;

/**
 * Created by aleks on 17.08.16.
 */
public class EditProfileViewModel extends BaseViewModel {

    private MainView mainView;

    public EditProfileViewModel(String title){
        mainView = new MainView(title);
    }

    public MainView getMainView() {
        return mainView;
    }
}
