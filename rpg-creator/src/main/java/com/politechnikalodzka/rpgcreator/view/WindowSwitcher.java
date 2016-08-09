package com.politechnikalodzka.rpgcreator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aleks on 06.07.16.
 */
public class WindowSwitcher {

    private WelcomeScreen welcomeScreen;
    private LogInFrame logInFrame;
    private EditProfileFrame editProfileFrame;
    private MainFrame mainFrame;
    private CharacterCreationFrame characterCreationFrame;
    private EditExistingCharactersFrame editExistingCharactersFrame;
    private GroupCreationFrame groupCreationFrame;
    private EditExistingGroupsFrame editExistingGroupsFrame;

    public WindowSwitcher(String appTitle){
        welcomeScreen = new WelcomeScreen(appTitle);
        logInFrame = new LogInFrame(appTitle);
        editProfileFrame = new EditProfileFrame(appTitle);
        mainFrame = new MainFrame(appTitle);
        characterCreationFrame = new CharacterCreationFrame(appTitle);
        editExistingCharactersFrame = new EditExistingCharactersFrame(appTitle);
        groupCreationFrame = new GroupCreationFrame(appTitle);
        editExistingGroupsFrame = new EditExistingGroupsFrame(appTitle);
        initializeSwitchingWindowsListeners();
    }

    private void initializeSwitchingWindowsListeners(){
        welcomeScreen.beginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(welcomeScreen, logInFrame);
            }
        });
        logInFrame.loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(logInFrame, mainFrame);
            }
        });
        mainFrame.editProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(mainFrame, editProfileFrame);
            }
        });
        mainFrame.createNewCharacterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(mainFrame, characterCreationFrame);
            }
        });
        mainFrame.editExistingCharactersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(mainFrame, editExistingCharactersFrame);
            }
        });
        mainFrame.createNewGroupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(mainFrame, groupCreationFrame);
            }
        });
        mainFrame.editExistingGroupsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(mainFrame, editExistingGroupsFrame);
            }
        });
        editProfileFrame.btnSaveChanges.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(editProfileFrame, mainFrame);
            }
        });
        characterCreationFrame.saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(characterCreationFrame, mainFrame);
            }
        });
        editExistingCharactersFrame.goBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(editExistingCharactersFrame, mainFrame);
            }
        });

        // TODO: Implement for groups views
        groupCreationFrame.saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchFrames(groupCreationFrame, mainFrame);
            }
        });
    }

    public void launchGui(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    welcomeScreen.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void switchFrames(JFrame actualFrame, JFrame nextFrame){
        if(actualFrame instanceof MainFrame){
            actualFrame.setVisible(false);
        }
        else{
            actualFrame.dispose();
        }
        nextFrame.setVisible(true);
    }

}
