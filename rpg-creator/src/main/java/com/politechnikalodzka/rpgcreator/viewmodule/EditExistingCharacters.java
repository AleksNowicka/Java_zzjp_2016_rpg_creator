package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditExistingCharacters {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditExistingCharacters window = new EditExistingCharacters();
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
	public EditExistingCharacters() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditExistingCharacters = new JLabel("Edit existing characters");
		lblEditExistingCharacters.setForeground(Color.LIGHT_GRAY);
		lblEditExistingCharacters.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEditExistingCharacters.setBounds(100, 11, 260, 25);
		frame.getContentPane().add(lblEditExistingCharacters);
		
		JButton btnCharacter = new JButton("Character 1");
		btnCharacter.setBounds(21, 47, 89, 23);
		frame.getContentPane().add(btnCharacter);
		
		JButton btnCharacter_1 = new JButton("Character 2");
		btnCharacter_1.setBounds(169, 47, 89, 23);
		frame.getContentPane().add(btnCharacter_1);
		
		JButton btnCharacter_2 = new JButton("Character 3");
		btnCharacter_2.setBounds(314, 47, 89, 23);
		frame.getContentPane().add(btnCharacter_2);
		
		JLabel lblGroup = new JLabel("Group 1");
		lblGroup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGroup.setForeground(Color.LIGHT_GRAY);
		lblGroup.setBounds(42, 81, 46, 14);
		frame.getContentPane().add(lblGroup);
		
		JLabel lblGroup_1 = new JLabel("Group 2");
		lblGroup_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGroup_1.setForeground(Color.LIGHT_GRAY);
		lblGroup_1.setBounds(189, 81, 46, 14);
		frame.getContentPane().add(lblGroup_1);
		
		JLabel label = new JLabel("Group 2");
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(339, 81, 46, 14);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 106, 89, 70);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(171, 106, 87, 70);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(314, 106, 89, 70);
		frame.getContentPane().add(panel_2);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.setBounds(21, 197, 89, 23);
		frame.getContentPane().add(btnGoBack);
	}
}
