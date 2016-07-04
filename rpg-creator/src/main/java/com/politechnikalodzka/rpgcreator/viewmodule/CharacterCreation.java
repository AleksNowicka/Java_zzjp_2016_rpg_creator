package com.politechnikalodzka.rpgcreator.viewmodule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CharacterCreation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharacterCreation window = new CharacterCreation();
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
	public CharacterCreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCharacterCreation = new JLabel("Character Creation");
		lblCharacterCreation.setForeground(Color.WHITE);
		lblCharacterCreation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCharacterCreation.setBounds(155, 11, 139, 21);
		frame.getContentPane().add(lblCharacterCreation);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblHair = new JLabel("Hair:");
		lblHair.setForeground(Color.WHITE);
		lblHair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHair.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblHair);
		
		JLabel lblHat = new JLabel("Hat:");
		lblHat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHat.setForeground(Color.WHITE);
		lblHat.setBounds(10, 95, 46, 14);
		frame.getContentPane().add(lblHat);
		
		JLabel lblOufit = new JLabel("Oufit:");
		lblOufit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOufit.setForeground(Color.WHITE);
		lblOufit.setBounds(10, 120, 46, 14);
		frame.getContentPane().add(lblOufit);
		
		JLabel lblEyes = new JLabel("Eyes:");
		lblEyes.setForeground(Color.WHITE);
		lblEyes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEyes.setBounds(10, 145, 46, 14);
		frame.getContentPane().add(lblEyes);
		
		JLabel lblAccessories = new JLabel("Accessories");
		lblAccessories.setForeground(Color.WHITE);
		lblAccessories.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccessories.setBounds(10, 170, 63, 14);
		frame.getContentPane().add(lblAccessories);
		
		JButton btnSelectGroup = new JButton("Select Group");
		btnSelectGroup.setBounds(10, 195, 99, 23);
		frame.getContentPane().add(btnSelectGroup);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(10, 229, 99, 23);
		frame.getContentPane().add(btnSave);
		
		JPanel panel = new JPanel();
		panel.setBounds(264, 43, 160, 207);
		frame.getContentPane().add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		comboBox.setBounds(97, 43, 99, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"long", "short"}));
		comboBox_1.setBounds(97, 68, 99, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ON", "OFF"}));
		comboBox_2.setBounds(97, 93, 99, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_3.setBounds(97, 118, 99, 20);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"brown", "green", "blue"}));
		comboBox_4.setBounds(97, 143, 99, 20);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox_5.setBounds(97, 168, 99, 20);
		frame.getContentPane().add(comboBox_5);
	}
}
