package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

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

public class GroupCreationView extends JFrame implements FrameSetter{

	private JTextField nameTextField;
	private JTextField passwordTextField;
	private JLabel frameNameLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JLabel maxGroupMembersLabel;
	private JLabel groupIconLabel;
	private JLabel membersLabel;
	private JComboBox maxGroupMembersComboBox;
	private JPanel groupIconPanel;
	private JButton saveButton;

	public GroupCreationView(String title) {
		super(title);

		setupContentPane();
		setupComponents();
		setupListeners();
	}

	public void setupContentPane() {
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupComponents() {
		frameNameLabel = new JLabel("Group Creation");
		frameNameLabel.setForeground(Color.LIGHT_GRAY);
		frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameNameLabel.setBounds(143, 11, 153, 25);
		getContentPane().add(frameNameLabel);

		nameLabel = new JLabel("Name:");
		nameLabel.setForeground(Color.LIGHT_GRAY);
		nameLabel.setBounds(24, 62, 46, 14);
		getContentPane().add(nameLabel);

		descriptionLabel = new JLabel("Description:");
		descriptionLabel.setForeground(Color.LIGHT_GRAY);
		descriptionLabel.setBounds(24, 87, 67, 14);
		getContentPane().add(descriptionLabel);

		maxGroupMembersLabel = new JLabel("Max group");
		maxGroupMembersLabel.setHorizontalAlignment(SwingConstants.LEFT);
		maxGroupMembersLabel.setVerticalAlignment(SwingConstants.TOP);
		maxGroupMembersLabel.setForeground(Color.LIGHT_GRAY);
		maxGroupMembersLabel.setBounds(24, 157, 56, 20);
		getContentPane().add(maxGroupMembersLabel);

		groupIconLabel = new JLabel("Group icon:");
		groupIconLabel.setForeground(Color.LIGHT_GRAY);
		groupIconLabel.setBounds(252, 62, 99, 14);
		getContentPane().add(groupIconLabel);

		nameTextField = new JTextField();
		nameTextField.setBounds(90, 59, 86, 20);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		passwordTextField = new JTextField();
		passwordTextField.setBounds(90, 87, 128, 59);
		getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);

		membersLabel = new JLabel("members:");
		membersLabel.setForeground(Color.LIGHT_GRAY);
		membersLabel.setBounds(24, 173, 67, 14);
		getContentPane().add(membersLabel);

		maxGroupMembersComboBox = new JComboBox();
		maxGroupMembersComboBox.setModel(new DefaultComboBoxModel(new String[] {"3", "5", "10"}));
		maxGroupMembersComboBox.setBounds(90, 163, 46, 20);
		getContentPane().add(maxGroupMembersComboBox);

		groupIconPanel = new JPanel();
		groupIconPanel.setBounds(322, 62, 90, 90);
		getContentPane().add(groupIconPanel);

		saveButton = new JButton("Save ");
		saveButton.setBounds(322, 186, 89, 23);
		getContentPane().add(saveButton);
	}

	public void setupListeners() {

	}
}
