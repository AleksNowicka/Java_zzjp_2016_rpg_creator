package com.politechnikalodzka.rpgcreator.view;

import com.politechnikalodzka.rpgcreator.interfaces.FrameSetter;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditExistingGroupsFrame extends JFrame implements FrameSetter{

	private JLabel frameNameLabel;
	private JButton editGroup1Button;
	private JButton editGroup2Button;
	private JButton editGroup3Button;
	private JPanel group1IconPanel;
	private JPanel group2IconPanel;
	private JPanel group3IconPanel;
	private JLabel character1Label;
	private JLabel character2Label;
	private JLabel character3Label;

	public EditExistingGroupsFrame(String title) {
		super(title);
		setupContentPane();
		setupComponents();
	}

	public void setupContentPane() {
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setupComponents() {
		frameNameLabel = new JLabel("Edit existing groups");
		frameNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameNameLabel.setForeground(Color.LIGHT_GRAY);
		frameNameLabel.setBackground(Color.WHITE);
		frameNameLabel.setBounds(117, 11, 211, 25);
		getContentPane().add(frameNameLabel);

		editGroup1Button = new JButton("Group 1");
		editGroup1Button.setBounds(21, 116, 89, 23);
		getContentPane().add(editGroup1Button);

		editGroup2Button = new JButton("Group 2");
		editGroup2Button.setBounds(167, 116, 89, 23);
		getContentPane().add(editGroup2Button);

		editGroup3Button = new JButton("Group 3");
		editGroup3Button.setBounds(319, 116, 89, 23);
		getContentPane().add(editGroup3Button);

		group1IconPanel = new JPanel();
		group1IconPanel.setBounds(21, 42, 89, 63);
		getContentPane().add(group1IconPanel);

		group2IconPanel = new JPanel();
		group2IconPanel.setBounds(167, 42, 89, 63);
		getContentPane().add(group2IconPanel);

		group3IconPanel = new JPanel();
		group3IconPanel.setBounds(319, 42, 89, 63);
		getContentPane().add(group3IconPanel);

		character1Label = new JLabel("Character 1");
		character1Label.setForeground(Color.LIGHT_GRAY);
		character1Label.setBounds(21, 150, 89, 14);
		getContentPane().add(character1Label);

		character2Label = new JLabel("Character 2");
		character2Label.setForeground(Color.LIGHT_GRAY);
		character2Label.setBounds(167, 150, 89, 14);
		getContentPane().add(character2Label);

		character3Label = new JLabel("Character 3");
		character3Label.setForeground(Color.LIGHT_GRAY);
		character3Label.setBounds(318, 150, 90, 14);
		getContentPane().add(character3Label);
	}

	public void setupListeners() {

	}
}
