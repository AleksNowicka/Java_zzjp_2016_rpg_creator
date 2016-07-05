package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditExistingGroups {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditExistingGroups window = new EditExistingGroups();
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
	public EditExistingGroups() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditExistingGroups = new JLabel("Edit existing groups");
		lblEditExistingGroups.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEditExistingGroups.setForeground(Color.LIGHT_GRAY);
		lblEditExistingGroups.setBackground(Color.WHITE);
		lblEditExistingGroups.setBounds(117, 11, 211, 25);
		frame.getContentPane().add(lblEditExistingGroups);
		
		JButton btnGroup = new JButton("Group 1");
		btnGroup.setBounds(21, 116, 89, 23);
		frame.getContentPane().add(btnGroup);
		
		JButton btnGroup_1 = new JButton("Group 2");
		btnGroup_1.setBounds(167, 116, 89, 23);
		frame.getContentPane().add(btnGroup_1);
		
		JButton btnGroup_2 = new JButton("Group 3");
		btnGroup_2.setBounds(319, 116, 89, 23);
		frame.getContentPane().add(btnGroup_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 42, 89, 63);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(167, 42, 89, 63);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(319, 42, 89, 63);
		frame.getContentPane().add(panel_2);
		
		JLabel lblCharacter = new JLabel("Character 1");
		lblCharacter.setForeground(Color.LIGHT_GRAY);
		lblCharacter.setBounds(21, 150, 89, 14);
		frame.getContentPane().add(lblCharacter);
		
		JLabel lblCharacter_1 = new JLabel("Character 2");
		lblCharacter_1.setForeground(Color.LIGHT_GRAY);
		lblCharacter_1.setBounds(167, 150, 89, 14);
		frame.getContentPane().add(lblCharacter_1);
		
		JLabel lblCharacter_2 = new JLabel("Character 3");
		lblCharacter_2.setForeground(Color.LIGHT_GRAY);
		lblCharacter_2.setBounds(318, 150, 90, 14);
		frame.getContentPane().add(lblCharacter_2);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
