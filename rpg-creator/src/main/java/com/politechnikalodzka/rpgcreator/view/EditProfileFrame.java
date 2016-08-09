package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class EditProfileFrame extends JFrame implements FrameSetter{

	public JButton btnSaveChanges;

	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JButton loadImageButton;
	private JLabel frameNameLabel;
	private JPanel userAvatarPanel;
	private JLabel editLoginLabel;
	private JLabel editPasswordLabel;

	public EditProfileFrame(String title) {
		super(title);
		setupContentPane();
		setupComponents();
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
		loginTextField.setColumns(10);
		getContentPane().add(loginTextField);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(182, 145, 86, 20);
		getContentPane().add(passwordField);

		btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(316, 173, 99, 23);
		getContentPane().add(btnSaveChanges);
	}

	public void setupListeners() {

	}
}
