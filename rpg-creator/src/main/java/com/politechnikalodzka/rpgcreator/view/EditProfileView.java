package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.EditProfileViewModel;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;

public class EditProfileView extends JFrame implements FrameSetter {

	private EditProfileViewModel editProfileViewModel;

	private JButton saveButon;
	private JTextField loginTextField;
	private JTextField passwordField;
	private JButton loadImageButton;
	private JLabel frameNameLabel;
	private JPanel userAvatarPanel;
	private JLabel editLoginLabel;
	private JLabel editPasswordLabel;

	public EditProfileView(String title) {
		super(title);
		final String appTitle = title;
		try {
			editProfileViewModel = new EditProfileViewModel(appTitle);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		setupContentPane();
		setupComponents();
		setupListeners();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setResizable(false);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupComponents() {
		frameNameLabel = new JLabel("Edit Profile");
		frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameNameLabel.setForeground(Color.LIGHT_GRAY);
		frameNameLabel.setBounds(154, 11, 136, 39);
		getContentPane().add(frameNameLabel);

		loadImageButton = new JButton("Load image");
		loadImageButton.setBounds(32, 72, 90, 23);
		getContentPane().add(loadImageButton);

		userAvatarPanel = new JPanel();
		userAvatarPanel.setBounds(32, 106, 90, 90);
		getContentPane().add(userAvatarPanel);

		editLoginLabel = new JLabel("Edit login:");
		editLoginLabel.setForeground(Color.LIGHT_GRAY);
		editLoginLabel.setBounds(182, 76, 67, 14);
		getContentPane().add(editLoginLabel);

		editPasswordLabel = new JLabel("Edit password:");
		editPasswordLabel.setForeground(Color.LIGHT_GRAY);
		editPasswordLabel.setBounds(182, 126, 78, 14);
		getContentPane().add(editPasswordLabel);

		loginTextField = new JTextField();
		loginTextField.setBounds(182, 95, 86, 20);
		loginTextField.setText(editProfileViewModel.getUser().getNick());
		getContentPane().add(loginTextField);

        //TODO Add text field for editing email address

		passwordField = new JTextField();
		passwordField.setBounds(182, 145, 86, 20);
		passwordField.setText(editProfileViewModel.getUser().getPassword());
		getContentPane().add(passwordField);

		saveButon = new JButton("Save changes");
		saveButon.setBounds(316, 173, 99, 23);
		getContentPane().add(saveButon);
	}

	public void setupListeners() {
        final EditProfileView classInstance = this;

        loadImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(classInstance);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                }
            }
        });

        saveButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    editProfileViewModel.updateUserData(loginTextField.getText(), passwordField.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                editProfileViewModel.switchFrames(classInstance, editProfileViewModel.getNavigationView());
                //TODO Add saving chosen icon and changed email address
            }
        });
	}
}
