package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class EditProfile {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfile window = new EditProfile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditProfile = new JLabel("Edit Profile");
		lblEditProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEditProfile.setForeground(Color.LIGHT_GRAY);
		lblEditProfile.setBounds(154, 11, 136, 39);
		frame.getContentPane().add(lblEditProfile);
		
		JButton btnLoadImage = new JButton("Load image");
		btnLoadImage.setBounds(32, 72, 90, 23);
		frame.getContentPane().add(btnLoadImage);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 106, 90, 90);
		frame.getContentPane().add(panel);
		
		JLabel lblEditLogin = new JLabel("Edit login:");
		lblEditLogin.setForeground(Color.LIGHT_GRAY);
		lblEditLogin.setBounds(182, 76, 67, 14);
		frame.getContentPane().add(lblEditLogin);
		
		JLabel lblEditPassword = new JLabel("Edit password:");
		lblEditPassword.setForeground(Color.LIGHT_GRAY);
		lblEditPassword.setBounds(182, 126, 78, 14);
		frame.getContentPane().add(lblEditPassword);
		
		textField = new JTextField();
		textField.setBounds(182, 95, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(182, 145, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(316, 173, 99, 23);
		frame.getContentPane().add(btnSaveChanges);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
