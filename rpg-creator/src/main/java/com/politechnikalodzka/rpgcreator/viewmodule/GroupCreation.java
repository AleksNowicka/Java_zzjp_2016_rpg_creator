package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GroupCreation {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupCreation window = new GroupCreation();
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
	public GroupCreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGroupCreation = new JLabel("Group Creation");
		lblGroupCreation.setForeground(Color.LIGHT_GRAY);
		lblGroupCreation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGroupCreation.setBounds(143, 11, 153, 25);
		frame.getContentPane().add(lblGroupCreation);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setBounds(24, 62, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.LIGHT_GRAY);
		lblDescription.setBounds(24, 87, 67, 14);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblMaxGroupMembers = new JLabel("Max group");
		lblMaxGroupMembers.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxGroupMembers.setVerticalAlignment(SwingConstants.TOP);
		lblMaxGroupMembers.setForeground(Color.LIGHT_GRAY);
		lblMaxGroupMembers.setBounds(24, 157, 56, 20);
		frame.getContentPane().add(lblMaxGroupMembers);
		
		JLabel lblGroupIcon = new JLabel("Group icon:");
		lblGroupIcon.setForeground(Color.LIGHT_GRAY);
		lblGroupIcon.setBounds(252, 62, 99, 14);
		frame.getContentPane().add(lblGroupIcon);
		
		textField = new JTextField();
		textField.setBounds(90, 59, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 87, 128, 59);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMembers = new JLabel("members:");
		lblMembers.setForeground(Color.LIGHT_GRAY);
		lblMembers.setBounds(24, 173, 67, 14);
		frame.getContentPane().add(lblMembers);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "10"}));
		comboBox.setBounds(90, 163, 46, 20);
		frame.getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(322, 62, 90, 90);
		frame.getContentPane().add(panel);
		
		JButton btnSave = new JButton("Save ");
		btnSave.setBounds(322, 186, 89, 23);
		frame.getContentPane().add(btnSave);
		frame.setBounds(100, 100, 450, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
