package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;
import com.politechnikalodzka.rpgcreator.viewmodel.MainViewModel;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainView extends JFrame implements FrameSetter{

	private MainViewModel mainViewModel;

	public JButton createNewCharacterButton;
	public JButton editExistingCharactersButton;
	public JButton createNewGroupButton;
	public JButton editExistingGroupsButton;
	public JButton editProfileButton;

	private JLabel welcomeMessageLabel;
	private JPanel userAvatarPanel;

	public MainView(String title) throws SQLException, ClassNotFoundException {
		super(title);
		mainViewModel = new MainViewModel(title);
		setupContentPane();
		setupComponents();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupComponents() {
		welcomeMessageLabel = new JLabel("Welcome <<User>>!");
		welcomeMessageLabel.setForeground(Color.LIGHT_GRAY);
		welcomeMessageLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		welcomeMessageLabel.setBounds(99, 11, 235, 29);
		getContentPane().add(welcomeMessageLabel);

		createNewCharacterButton = new JButton("Create new character");
		createNewCharacterButton.setBounds(22, 64, 145, 23);
		getContentPane().add(createNewCharacterButton);

		editExistingCharactersButton = new JButton("Edit existing characters");
		editExistingCharactersButton.setBounds(22, 98, 145, 23);
		getContentPane().add(editExistingCharactersButton);

		createNewGroupButton = new JButton("Create new group");
		createNewGroupButton.setBounds(22, 152, 145, 23);
		getContentPane().add(createNewGroupButton);

		editExistingGroupsButton = new JButton("Edit existing groups");
		editExistingGroupsButton.setBounds(22, 186, 145, 23);
		getContentPane().add(editExistingGroupsButton);

		userAvatarPanel = new JPanel();
		userAvatarPanel.setBounds(323, 64, 70, 70);
		getContentPane().add(userAvatarPanel);

		editProfileButton = new JButton("Edit your profile");
		editProfileButton.setBounds(302, 152, 109, 23);
		getContentPane().add(editProfileButton);
	}

	public void setupListeners() {

	}
}
