package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome <<User>>!");
		lblWelcome.setForeground(Color.LIGHT_GRAY);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(99, 11, 235, 29);
		frame.getContentPane().add(lblWelcome);
		
		JButton btnCreateNewCharacter = new JButton("Create new character");
		btnCreateNewCharacter.setBounds(22, 64, 145, 23);
		frame.getContentPane().add(btnCreateNewCharacter);
		
		JButton btnEditExistingCharacters = new JButton("Edit existing characters");
		btnEditExistingCharacters.setBounds(22, 98, 145, 23);
		frame.getContentPane().add(btnEditExistingCharacters);
		
		JButton btnCreateNewGroup = new JButton("Create new group");
		btnCreateNewGroup.setBounds(22, 152, 145, 23);
		frame.getContentPane().add(btnCreateNewGroup);
		
		JButton btnEditExistingGroups = new JButton("Edit existing groups");
		btnEditExistingGroups.setBounds(22, 186, 145, 23);
		frame.getContentPane().add(btnEditExistingGroups);
		
		JPanel panel = new JPanel();
		panel.setBounds(323, 64, 70, 70);
		frame.getContentPane().add(panel);
		
		JButton btnEditProfile = new JButton("Edit your profile");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditProfile.setBounds(302, 152, 109, 23);
		frame.getContentPane().add(btnEditProfile);
		frame.setBounds(100, 100, 450, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
